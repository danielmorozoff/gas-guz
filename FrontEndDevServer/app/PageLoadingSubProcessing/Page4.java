package PageLoadingSubProcessing;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.neo4j.graphdb.Node;

import Users.GenericUserMethods;
import Users.User;

public class Page4 {

private User user=null;
	
	public Page4(Node userNode){
		this.user =(User)new GenericUserMethods().convertUserNodeToUserObject(userNode, new User(), new ArrayList <String>()) ;
	}
	
	public String loadWhatToBuy(String tagString){
		Document doc = Jsoup.parseBodyFragment(tagString);
		return doc.toString();
	}
	public String loadPaymentType(String tagString){
		Document doc = Jsoup.parseBodyFragment(tagString);
		return doc.toString();
	}
}
