package PageLoadingSubProcessing;

import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.neo4j.graphdb.Node;

import Users.GenericUserMethods;
import Users.User;

public class Page2 {

	private User user=null;
	
	public Page2(Node userNode){
		this.user =(User)new GenericUserMethods().convertUserNodeToUserObject(userNode, new User(), new ArrayList <String>()) ;
	}
	
	public String loadPersonalInformation(String tagString){
		Document doc = Jsoup.parseBodyFragment(tagString);
			//Set personal property elements
			doc.getElementById("fNameDiv").child(0).text(user.fName);
			doc.getElementById("lNameDiv").child(0).text(user.lName);
			doc.getElementById("emailDiv").child(0).text(user.email);
			doc.getElementById("phoneNumberDiv").child(0).text(user.phone);
		return doc.toString();
	}
	public String loadPaymentMethods(String tagString){
		Document doc = Jsoup.parseBodyFragment(tagString);
		return doc.toString();
	}
	public String loadAccountStats(String tagString){
		Document doc = Jsoup.parseBodyFragment(tagString);
		return doc.toString();
	}
	

}
