package Users;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;

public class User {
	
	public String publicId;
	public String privateId;
	
	public String username;
	public String password;
	public String email;
	
	public String phone;
	public String status;
	
	public long dateCreated = 0;
	public long dateModified = 0;
	
	
	
}
