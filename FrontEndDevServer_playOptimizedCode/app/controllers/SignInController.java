package controllers;

import pageLoaderPackage.UserEntrance;
import play.mvc.Controller;

public class SignInController extends Controller {
	
	/**
	 * Beginning of Login flow
	 * @param username
	 * @param password
	 */
	public static void loginToSite(String username, String password){
		UserEntrance entranceClass = new UserEntrance();
		if(entranceClass.testLoginInfo(username, password, "userName")){
			//Login in to site
		}
		else{
			flash.error(entranceClass.errorString);
		}
	}

}
