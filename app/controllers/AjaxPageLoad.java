package controllers;

import org.neo4j.shell.util.json.JSONException;
import org.neo4j.shell.util.json.JSONObject;

import pageLoaderPackage.PageLoadManager;
import play.mvc.Controller;

public class AjaxPageLoad extends Controller {
	
	public static JSONObject loadSpecificPage(String pageId) throws JSONException{
		System.out.println("Loading Page: "+pageId);
		return new PageLoadManager().loadPage(pageId) ;
	}

}
