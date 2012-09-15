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

import Users.User;

import Database.EmailDatabase;
import Database.UserDatabase;



public class PreInitiationController extends Controller {
	@OnApplicationStart
	public class startupCode extends Job {
	    public void doJob() {
	    	//load Email DB.
	    	new UserDatabase();
	    	new EmailDatabase();
	    }    
	}

    
   
    
}