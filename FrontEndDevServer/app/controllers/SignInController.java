package controllers;

import java.io.IOException;
import java.util.UUID;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.shell.util.json.JSONObject;

import Database.UserDatabase;
import Emailer.ForgotPassEmailer;
import Emailer.SignupEmailer;
import Users.GenericUserMethods;
import Users.User;
import Users.Client.ClientMethods;
import pageLoaderPackage.UserEntrance;
import play.cache.Cache;
import play.mvc.Before;
import play.mvc.Controller;

public class SignInController extends Controller {
	public static GraphDatabaseService uDB = UserDatabase.uDB;
	

	@Before(unless={"resetPassword","linkToResetPassword","forgotEmail","loginToSite"})
	public static void authentify(){
		
		checkAuthenticity();
		//User not logged in
		System.out.println("Session: "+Cache.get(session.getAuthenticityToken()));
		if(Cache.get(session.getAuthenticityToken())==null){
			SignInController.loginToSite((String)Cache.get(session.getAuthenticityToken()), null);
		}
	}
	/**
	 * Beginning of Login flow
	 * @param username
	 * @param password
	 */
	 
	public static void loginToSite(String userName, String password){
		UserEntrance entranceClass = new UserEntrance();
		System.out.println("AUTH token: "+session.getAuthenticityToken());
			if(Cache.get(session.getAuthenticityToken())==null){
				if(userName!=null){
				Node curNode = UserDatabase.uDB.index().forNodes("users").get("userName", userName).getSingle();
					if(curNode!=null){
						if(!(Boolean) curNode.getProperty("emailVerified")){
							//Render Validation page
							System.out.println("Need to Validate Email");
							String pubUserId = (String) curNode.getProperty("publicId");
							System.out.println("pubUserId: "+pubUserId);
							renderTemplate("app/views/Application/EmailValidation.html",pubUserId );
						}
					}
				}
				
				if(entranceClass.testLoginInfo(userName, password, "userName")){
					System.out.println("Logging in: "+userName);
					//Login in to site
					Cache.set(session.getAuthenticityToken(), userName);
					GeneralController.dashboardPg(entranceClass.loggedInUser.publicId);
				}
				else{
					System.out.println("auth tok null");
					flash.error(entranceClass.errorString);
					GeneralController.welcomePage();
				}
			
			}
			else{
				System.out.println("Auth tok not null- loggin"+Cache.get(session.getAuthenticityToken())+"in...");
					//Login in to site
					Cache.set(session.getAuthenticityToken(), Cache.get(session.getAuthenticityToken()));
					GeneralController.dashboardPg(entranceClass.loggedInUser.publicId);
			}
		
	}
	

	/**
	 * Create new user in DB
	 * @param userClass
	 * @return
	 * @throws Exception 
	 */
	public static String signUpUser(String userObj) throws Exception{
		JSONObject jObj = new JSONObject(userObj);
	
		User newUser = new User();
		String userName=(String)jObj.get("userName"),
				password=(String)jObj.get("password"),
				email=(String)jObj.get("email"),
				fName=(String)jObj.get("fName"),
				lName=(String)jObj.get("lName");
			
			//In the future we will have a different flow to signup stations
			//new ClientMethods().addClient(userName, password, email,fName,lName, "", "");
			newUser.loadUserClassForSignup(userName, password, email,fName,lName, "", "");
			
		
			UserEntrance uEnter = new UserEntrance();
			String userExistsTestResult = uEnter.checkIfUserExistsInDb(userName, password, email); 
			if(userExistsTestResult.equals("false")){
				if(uEnter.makeNewUser(newUser)){
					Node userNode = uDB.index().forNodes("users").get("userName", userName).getSingle();
					new SignupEmailer().sendSignupEmail(email, userName,(String)userNode.getProperty("fName"),(String)userNode.getProperty("uniqueEmailVerificationString"));
					return "userCreated_"+newUser.userName;
				}
				else return "UserNOTCREATED";
			}
			else{
				return userExistsTestResult;
			}
		
	}
	/**
	 * Method for verifying provided email
	 * @param emailValidationCode
	 */
	public static void validateEmail(String emailValidationCode, String pubId){
		System.out.println("Verifying Email for: "+pubId);
		Node userNode = uDB.index().forNodes("users").get("publicId", pubId).getSingle();
		if(userNode!=null){
			if(userNode.getProperty("uniqueEmailVerificationString").equals(emailValidationCode)){
				//pass test update db
				System.out.println("Email verified for: "+pubId);
				try{
					Transaction tx = uDB.beginTx();
						userNode.setProperty("emailVerified", true);
						userNode.setProperty("uniqueEmailVerificationString", "");
					tx.success();
					tx.finish();
				
					User user = (User)new GenericUserMethods().convertUserNodeToUserObject(userNode, new User(), null);
					Cache.set(session.getAuthenticityToken(), userNode.getProperty("userName"));
					GeneralController.dashboardPg(user.publicId);
				}catch(RuntimeException e){
					e.printStackTrace();
				}
			}
			
		}
		else{
			renderTemplate("app/views/Application/EmailValidation.html" );
		}
	}
	/**
	 * Method fired from the Welcome page to reset email
	 * @param lName
	 * @param email
	 * @throws Exception 
	 */
	public static String forgotEmail(String lName, String email) throws Exception{
		System.out.println("User forgot email... ");
		System.out.println("Email: "+email);
		System.out.println("lName: "+lName);
		Node potentialUser =uDB.index().forNodes("users").get("email", email).getSingle();
		if(potentialUser!=null){
			System.out.println("Email found...");
			if(potentialUser.getProperty("lName").equals(lName)){
				System.out.println("lastNames are equal...");
				//Set unique code for user who requested reset	
				try{
				String verificationCodeForEmailReset = UUID.randomUUID().toString();
				Transaction tx=uDB.beginTx();
					potentialUser.setProperty("uniqueEmailVerificationString", verificationCodeForEmailReset);
				tx.success();
				tx.finish();
				//Send email to allow user to change his password
				new ForgotPassEmailer().sendForgotPassEmail(email, (String) potentialUser.getProperty("fName"), 
						(String)potentialUser.getProperty("publicId"), verificationCodeForEmailReset);
					return "sentEmail";
				}catch(RuntimeException e){
					e.printStackTrace();
				}
			}
		}
		return "emailNotSent";
	}
	/**
	 * This is the request that comes in from the email sent to a user.
	 */
	public static void linkToResetPassword(){
		System.out.println("Password reset link");
		String reqUrl = request.url;
			String tempStr= reqUrl.substring(15);
		String pubId = tempStr.substring(0,tempStr.indexOf("/"));
		tempStr=null;
				Node userNode =uDB.index().forNodes("users").get("publicId", pubId).getSingle();
		if(userNode!=null){
			String uniqueCode =reqUrl.substring(reqUrl.lastIndexOf("/")+1);
				if(userNode.getProperty("uniqueEmailVerificationString").equals(uniqueCode)){
					//render resetTemplate page 
					renderTemplate("app/views/Application/passwordReset.html",uniqueCode,pubId);
				}
		}
	}
	/**
	 * Actual reset of password method
	 * @param uniqueCode
	 * @param pubId
	 * @param newPass1
	 * @param newPass2
	 * @return
	 * @throws Exception 
	 */
	public static String resetPassword(String uniqueCode, String pubId, String newPass1, String newPass2) throws Exception{
		checkAuthenticity();
		System.out.println("RESETING PASSWORD");
		
		Node userNode =uDB.index().forNodes("users").get("publicId", pubId).getSingle();
		if(userNode!=null){
				if(userNode.getProperty("uniqueEmailVerificationString").equals(uniqueCode)){
					if(newPass1.equals(newPass2) && newPass1.length()>=7){
						System.out.println("Setting new password...");
						try{
							Transaction tx = uDB.beginTx();
								//reset password
								String newPSalt =UUID.randomUUID().toString();
								newPass1 = new UserEntrance().encryptPassword(newPass1, "userCreation", null,newPSalt );
								GenericUserMethods genMeths = new GenericUserMethods();
									genMeths.setNodeProperty(userNode, "password", newPass1, true, null);
									genMeths.setNodeProperty(userNode, "salty", newPSalt, true, null);
							//Clear the unique code
								userNode.setProperty("uniqueEmailVerificationString", "");
							tx.success();
							tx.finish();
							
							GeneralController.welcomePage();
						}catch(RuntimeException e){
							e.printStackTrace();
						}
					}
					else{
						return "passDoesNotMatch";
					}
				}
		}
		
		return "userDiscError";
		
	}
	public static void logoutAndClearCache(){
		
		response.cookies.clear();
		Cache.delete(session.getAuthenticityToken());
		GeneralController.welcomePage();
	}	
	

}
