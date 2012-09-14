package pageLoaderPackage;

import java.lang.reflect.Field;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.index.Index;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.graphdb.index.IndexManager;

import scala.actors.threadpool.Arrays;

import Users.GenericUserMethods;
import Users.User;



import Database.UserDatabase;

public class UserEntrance {

	GraphDatabaseService userDB = UserDatabase.uDB; 
	public String errorString;
	public User loggedInUser = null;
	
	
	public boolean makeNewUser(User userClass){
			
			 IndexManager userIndex = userDB.index();
			 
		boolean userSaved = false;
		//If traffic gets bigger will need to do batchInserter methods instead of transactions
		try{
		Transaction transaction = userDB.beginTx();
		
		Node userNode = userDB.createNode();
		//add to index
		Index<Node> userNameIndex = userIndex.forNodes( "users" ); 	
			System.out.println("***Loading User params.***");
		Field[] userFields = userClass.getClass().getDeclaredFields();
			for(int i=0; i<userFields.length;i++){
				if(!userFields[i].getName().equals("userDB")){
				System.out.println("Name: "+userFields[i].getName()+" ClassObject:  "+userFields[i].get(userClass) );
				if(userFields[i].get(userClass)!=null){
					userNode.setProperty(userFields[i].getName(), userFields[i].get(userClass));
				}
				else{
					userNode.setProperty(userFields[i].getName(), "");
				}
				}
			}
			//This overrides the default prop of 0
			
			System.out.println("Adding "+userClass.userName+" to index via "+ userNode);
		
			userNameIndex.add(userNode, "userName", userClass.userName);
			userNameIndex.add(userNode, "email", userClass.email);
			
			transaction.success();
			transaction.finish();
		
			System.out.println("User creation transaction complete");
			userSaved = true;
		}
		catch(Exception e){
			System.out.println("****Exception in Creating New User after encryption of password******");
			e.printStackTrace();
		}
		return userSaved;
	}
	/**
	 * Test a users credentials and log him in
	 * @param userName
	 * @param password
	 * @param type
	 * @return
	 */
	 public boolean testLoginInfo(String userName, String password,String type){
	//	System.out.println("Logging "+userName+" into site");
		boolean enter = false;
		if (userName !=null && password!=null && userDB.index().existsForNodes("users") ){
		 IndexManager userIndex = userDB.index();
		 
		 String encryptedInputPass="";
		 IndexHits <Node> hits=null;
				if(type.equals("userName")){
					hits = userIndex.forNodes("users").get("userName", userName);
				}
				else if(type.equals("email")){
					
					System.out.println("getting email");
					System.out.println(userIndex.forNodes("users").get("email", userName).getSingle());
					hits = userIndex.forNodes("users").get("email", userName);
				}
				Node curNode = (Node) hits.getSingle();
				if(curNode!=null){
					if(curNode.getProperty("userName").equals(userName) && type.equals("userName")){
								
										try {
											encryptedInputPass = encryptPassword(password,"userValidation",curNode,null);
										} catch (Exception e) {
											System.out.println("*****Password Encryption Error in !!!testLoginInfo!!!****");
											errorString = "User / password combination not found.";
											e.printStackTrace();
										}
										String hashedDbPass =(String) curNode.getProperty("password");
										
										if(hashedDbPass.equals(encryptedInputPass)){
											enter = true;
											loggedInUser =(User) new GenericUserMethods().convertUserNodeToUserObject(curNode,new User(), null);
										}
										else{
											enter=false;
											errorString = "User / password combination not found.";
										}
					}
				}
				else{
					errorString="User not found.";
				}
		}
		errorString="Server Error.";
		return enter;
	 }
	public String checkIfUserExistsInDb(String userName, String password, String email){
		String userExists ="false";

		IndexManager userIndex = userDB.index();
		Node hit =  userIndex.forNodes( "users" ).get("userName", userName).getSingle();
			if(hit!=null){
				if(hit.getProperty("userName").equals(userName)){
					userExists = "Username exists";
					setErrorMessage("Username exists");
				}
			}
		if(userExists.equals("false")){
			Node emailHit = userIndex.forNodes( "users" ).get("email", email).getSingle();
			if(emailHit!=null){
				if(emailHit.getProperty("email").equals(email)){
					userExists = "Email exists";
					setErrorMessage("Email exists");
				}
			}
		}
		 return userExists;
		 
	 }

	public String encryptPassword(String password,String operation,Node potentialNode, String pSalt) throws Exception{
		 
		 String hash = byteArrayToHexString(computeHash(password,operation,potentialNode, pSalt));
	  //   System.out.println("the computed hash (hex string) : " + hash); 
	     return hash;
	 }
	 
	 private  byte[] computeHash(String x,String operation, Node potentialNode, String pSalt)   
			  throws Exception  
			  {
			     java.security.MessageDigest d =null;
			     d = java.security.MessageDigest.getInstance("SHA-256");
			     d.reset();
			     //Pre-salt key
			     String presalt = "&salting<98Yu!F>3;uc1k(_*!!" ;
		//	     System.out.println("operation: "+operation);
			     String postSalt ="";
			     if(operation.equals("userCreation") && potentialNode == null && pSalt!=null){
			    	 //salt created in the loadUser method in User Class
			    	 postSalt = pSalt;
			     }
			     if(operation.equals("userValidation") && potentialNode != null && pSalt==null ){
			    	postSalt = (String) potentialNode.getProperty("salty");
			    //	System.out.println("retrieved postsalt: "+postSalt);
			     }
			     d.update((presalt+x+postSalt).getBytes());
			     return  d.digest();
			  }
			  
	private  String byteArrayToHexString(byte[] b){
		StringBuffer sb = new StringBuffer(b.length * 2);
	    for (int i = 0; i < b.length; i++){
			       int v = b[i] & 0xff;
			       
			       if (v < 131) {
			         sb.append('1');
			       }
		sb.append(Integer.toHexString(v));
			     }
	   return sb.toString().toUpperCase();
			  }

	
	public void setErrorMessage(String errorString){
		 this.errorString = errorString; 
	}
	
}

