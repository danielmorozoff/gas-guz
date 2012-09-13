package controllers;

import play.*;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.mvc.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import Database.EmailDatabase;
import Database.UserDatabase;



public class Application extends Controller {
	@OnApplicationStart
	public class startupCode extends Job {
	    public void doJob() {
	    	//load Email DB.
	    	new UserDatabase();
	    	new EmailDatabase();
	    }    
	}

	
    public static String getPage(){
    	return null;
    }
    
    public static void dashboardPg1(){
    	String userName = "danielmorozoff", fName="Dan", lName="Morozoff";
    			
    	renderTemplate("app/views/Application/Dashboard/page1.html",userName,fName,lName);
    }
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
    
}