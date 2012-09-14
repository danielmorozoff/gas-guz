package controllers;

import org.neo4j.shell.util.json.JSONObject;

import Users.User;
import pageLoaderPackage.UserEntrance;
import play.cache.Cache;
import play.mvc.Controller;

public class SignInController extends Controller {
	
	/**
	 * Beginning of Login flow
	 * @param username
	 * @param password
	 */
	 
	public static void loginToSite(String userName, String password){
		UserEntrance entranceClass = new UserEntrance();
		System.out.println("AUTH token: "+session.getAuthenticityToken());
			if(Cache.get(session.getAuthenticityToken())==null){
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
			newUser.loadUserClass((String)jObj.get("userName"), (String)jObj.get("password"), (String)jObj.get("email"), "", "");
		
		
			UserEntrance uEnter = new UserEntrance();
			if(uEnter.makeNewUser(newUser)) return "userCreated_"+newUser.userName;
			else return "UserNOTCREATED";
		
	}

	
	public static void logoutAndClearCache(){
		response.cookies.clear();
		Cache.delete(session.getAuthenticityToken());
		GeneralController.welcomePage();
	}	
	

}
