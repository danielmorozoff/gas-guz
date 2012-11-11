package PageLoadingSubProcessing;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.neo4j.graphdb.Node;

import Users.GenericUserMethods;
import Users.User;

public class Page1 {

private User user=null;
	
	public Page1(Node userNode){
		this.user =(User)new GenericUserMethods().convertUserNodeToUserObject(userNode, new User(), new ArrayList <String>()) ;
	}
	
	public String loadStations(String tagString){
		Document doc = Jsoup.parseBodyFragment(tagString);
		return doc.toString();
	}
	public String loadConsumptionStats(String tagString){
		Document doc = Jsoup.parseBodyFragment(tagString);
		return doc.toString();
	}
}
