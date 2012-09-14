package Users;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

import pageLoaderPackage.UserEntrance;

public class User {
	
	public String publicId;
	public String privateId;
	
	public String userName;
	public String password;
	public String salty;
	public String email;
	
	public String phone;
	public String status;
	
	public long dateCreated = 0;
	public long dateModified = 0;
	
	public void loadUserClass(String userName,String password, String email, String phone, String status ) throws Exception{
		UserEntrance uEnter = new UserEntrance();
		this.privateId = UUID.randomUUID().toString();
		this.publicId = UUID.randomUUID().toString();
		this.userName = userName;
		this.salty= UUID.randomUUID().toString();
		this.password = uEnter.encryptPassword(password, "userCreation", null, salty);
		System.out.println("loading "+this.userName);
		System.out.println("pass: "+this.password);
		this.email=email;
		this.phone="";
		this.status="fullFunction";
		long curTime = System.currentTimeMillis();
		this.dateCreated  = curTime;
		this.dateModified = curTime;
	}
	
	
	
}
