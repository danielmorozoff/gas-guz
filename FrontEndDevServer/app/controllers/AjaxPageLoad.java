package controllers;

import org.neo4j.shell.util.json.JSONException;
import org.neo4j.shell.util.json.JSONObject;

import pageLoaderPackage.PageLoadManager;
import play.mvc.Controller;

public class AjaxPageLoad extends Controller {
	
	public static JSONObject loadSpecificPage(String publicUserId, String pageId, String authTok) throws JSONException{
		System.out.println("Public user ID: "+publicUserId);
		System.out.println("Auth Tok: "+authTok);
		System.out.println("Loading Page: "+pageId);
		System.out.println("***************************");
		if(authTok.equals(session.getAuthenticityToken()))return new PageLoadManager(publicUserId).loadPage(pageId) ;
		else return null;
	}

}
