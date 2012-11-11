package controllers;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import Database.UserDatabase;
import play.cache.Cache;
import play.mvc.Before;
import play.mvc.Controller;

public class ModificationController extends Controller{
	static GraphDatabaseService uDB = UserDatabase.uDB;
	
	@Before
	 public static void authentify(String authTok){
		if(Cache.get(authTok)==null){
			SignInController.logoutAndClearCache();
		}
	}
	
	public static void setUserPersonalInfo(String pubId, String paramName, String newVal){
		System.out.println("PubId: "+pubId);
		String dbParam="";
		if(paramName.equals("phoneNumberDiv")){
			dbParam="phone";
		}else if(paramName.equals("addressDiv")){
			dbParam="address";
		}else if(paramName.equals("emailDiv")){
			dbParam="email";
		}else if (paramName.equals("lNameDiv")){
			dbParam="lName";
		}else if (paramName.equals("fNameDiv")){
			dbParam="fName";
		}
		Node userNode =uDB.index().forNodes("users").get("publicId",pubId).getSingle();
			if(userNode!=null){
				if(userNode.hasProperty(dbParam)){
					System.out.println("PARAMETER EXISTS: "+dbParam);
				}
				else{
					System.out.println("PARAMETER DOES NOT EXIST: "+paramName);
				}
			}
		
	}

}
