package PageLoadingSubProcessing;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.neo4j.graphdb.Node;

import Users.GenericUserMethods;
import Users.User;

public class Page3 {

private User user=null;
	
	public Page3(Node userNode){
		this.user =(User)new GenericUserMethods().convertUserNodeToUserObject(userNode, new User(), new ArrayList <String>()) ;
	}
	
	public String loadUsersDiv(String tagString){
		Document doc = Jsoup.parseBodyFragment(tagString);
		return doc.toString();
	}
	public String loadUserGallons(String tagString){
		Document doc = Jsoup.parseBodyFragment(tagString);
		return doc.toString();
	}
	
}
