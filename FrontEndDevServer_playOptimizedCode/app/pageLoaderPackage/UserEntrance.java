package pageLoaderPackage;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.index.IndexHits;
import org.neo4j.graphdb.index.IndexManager;

import Database.UserDatabase;

public class UserEntrance {

	GraphDatabaseService userDB = UserDatabase.uDB; ;
	public String errorString;
	
	/**
	 * Test a users credentials and log him in
	 * @param userName
	 * @param password
	 * @param type
	 * @return
	 */
	 public boolean testLoginInfo(String userName, String password,String type){
		
		boolean enter = false;
		if (userName !=null || password!=null ){
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
											encryptedInputPass = encryptPassword(password,"userValidation",curNode);
										} catch (Exception e) {
											System.out.println("*****Password Encryption Error in !!!testLoginInfo!!!****");
											errorString = "User / password combination not found.";
											e.printStackTrace();
										}
										String hashedDbPass =(String) curNode.getProperty("hashedPassword");
										
										if(hashedDbPass.equals(encryptedInputPass)){
											enter = true;
										}
										else{
											enter=false;
											errorString = "User / password combination not found.";
										}
					}
				}
		}
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

	private String encryptPassword(String password,String operation,Node potentialNode) throws Exception{
		 
		 String hash = byteArrayToHexString(computeHash(password,operation,potentialNode));
	  //   System.out.println("the computed hash (hex string) : " + hash); 
	     return hash;
	 }
	 
	 private  byte[] computeHash(String x,String operation, Node potentialNode)   
			  throws Exception  
			  {
			     java.security.MessageDigest d =null;
			     d = java.security.MessageDigest.getInstance("SHA-256");
			     d.reset();
			     //Pre-salt key
			     String presalt = "&salting<98Yu!F>3;uc1k(_*!!" ;
		//	     System.out.println("operation: "+operation);
			     String postSalt ="";
			     if(operation.equals("userCreation") && potentialNode == null){
			     postSalt = Long.toString(System.currentTimeMillis());
			    // System.out.println("generating salt: "+postSalt);
			     }
			     if(operation.equals("userValidation") && potentialNode != null ){
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

