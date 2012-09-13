package controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import Database.EmailDatabase;
import play.mvc.Controller;

public class GeneralController extends Controller {

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
    
	
	
}
