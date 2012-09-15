package controllers;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.shell.util.json.JSONObject;

import Database.UserDatabase;
import Emailer.SignupEmailer;
import Users.GenericUserMethods;
import Users.User;
import pageLoaderPackage.UserEntrance;
import play.cache.Cache;
import play.mvc.Controller;

public class SignInController extends Controller {
	public static GraphDatabaseService uDB = UserDatabase.uDB;
	
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
					GeneralController.dashboardPg1(entranceClass.loggedInUser);
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
					GeneralController.dashboardPg1(entranceClass.loggedInUser);
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
					GeneralController.dashboardPg1(user);
				}catch(RuntimeException e){
					e.printStackTrace();
				}
			}
			
		}
		else{
			renderTemplate("app/views/Application/EmailValidation.html" );
		}
	}
	
	public static void logoutAndClearCache(){
		response.cookies.clear();
		Cache.delete(session.getAuthenticityToken());
		GeneralController.welcomePage();
	}	
	

}
