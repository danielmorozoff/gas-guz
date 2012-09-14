package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import Users.User;


import Database.EmailDatabase;
import play.cache.Cache;
import play.mvc.Before;
import play.mvc.Controller;

public class GeneralController extends Controller {
	
	@Before(unless="welcomePage")
	public static void authentify(){
		//User not logged in
		System.out.println("Session: "+Cache.get(session.getAuthenticityToken()));
		if(Cache.get(session.getAuthenticityToken())==null){
			SignInController.loginToSite((String)Cache.get(session.getAuthenticityToken()), null);
		}
	}
	
	
	static GraphDatabaseService eDB = EmailDatabase.eDB;
   
	public static void welcomePage() {
        renderTemplate("app/views/Application/WelcomePage.html");
    }
    
    public static String saveEmail(String emailAddress, String authTok){
    	if(authTok.equals(session.getAuthenticityToken())){
    		try{
    			if(eDB.index().forNodes("emails").get("email", emailAddress).getSingle()==null){
	    			Transaction tx = eDB.beginTx();
	    		
		    		Node emailNode = eDB.createNode();
		    			emailNode.setProperty("emailAddress",emailAddress);
		    			emailNode.setProperty("longDate", System.currentTimeMillis());
		    			
		    			SimpleDateFormat sDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		    			Date date = new Date();
		    			emailNode.setProperty("formattedDate", sDate.format(date));
		    		
		    		//index
		    		eDB.index().forNodes("emails").add(emailNode,"email",emailAddress);	
		    		
		    		System.out.println("***Email Stored***");
		    		tx.success();
		    		tx.finish();
    			}
    			else{
    				return "Already Registered";
    			}
    		}catch(RuntimeException e){
    			e.printStackTrace();
    		}
    		
    		return "Success";
    	}
    	else return null;
    }
  //Page Template Rendering
    public static void dashboardPg1(User user){
    	String userName = "danielmorozoff", fName="Dan", lName="Morozoff";
    	renderTemplate("app/views/Application/Dashboard/page1.html",userName,fName,lName);
    }
  
    /*
    public static void dashboardPg2(){
    	String userName = "danielmorozoff", fName="Dan", lName="Morozoff";
    			
    	renderTemplate("app/views/Application/Dashboard/page2.html",userName,fName,lName);
    }
    public static void dashboardPg3(){
    	String userName = "danielmorozoff", fName="Dan", lName="Morozoff";
    			
    	renderTemplate("app/views/Application/Dashboard/page3.html",userName,fName,lName);
    }
    public static void dashboardPg4(){
    	String userName = "danielmorozoff", fName="Dan", lName="Morozoff";
    			
    	renderTemplate("app/views/Application/Dashboard/page4.html",userName,fName,lName);
    }
	*/
	
}
