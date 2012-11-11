package pageLoaderPackage;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.shell.util.json.JSONException;
import org.neo4j.shell.util.json.JSONObject;

import Database.UserDatabase;
import PageLoadingSubProcessing.AllPageMethods;
import PageLoadingSubProcessing.Page1;
import PageLoadingSubProcessing.Page2;
import PageLoadingSubProcessing.Page3;
import PageLoadingSubProcessing.Page4;
import Users.User;

public class PageLoadManager {
	GraphDatabaseService uDB = UserDatabase.uDB;
	private Node userNode;
	
	public PageLoadManager(String pID){
		this.userNode= uDB.index().forNodes("users").get("publicId", pID).getSingle();
	}
	public JSONObject loadPage(String pageId){
		
		String pageToRef= "";
		
		TagLoader tLoader = new TagLoader(pageId);
		AllPageMethods pageMethods = new AllPageMethods();
		
		System.out.println("PAGEId: "+pageId);
		//Order of tags matters
		if(pageId.contains("1")){
			Page1 page1 = new Page1(userNode);
			pageToRef = "navOption1";
			pageMethods.combineTagStringIntoFinalString(page1.loadStations(tLoader.getHtmlStringForTag("stationsTag")));
			pageMethods.combineTagStringIntoFinalString(page1.loadConsumptionStats(tLoader.getHtmlStringForTag("consumpStatsTag")));
		}
		else if(pageId.contains("2")){
			Page2 page2=  new Page2(userNode);
			pageToRef = "navOption2";
			pageMethods.combineTagStringIntoFinalString(page2.loadPersonalInformation(tLoader.getHtmlStringForTag("personalInfo")));
			pageMethods.combineTagStringIntoFinalString(page2.loadPaymentMethods(tLoader.getHtmlStringForTag("paymentMeth")));
			pageMethods.combineTagStringIntoFinalString(page2.loadAccountStats(tLoader.getHtmlStringForTag("accountStats")));
		}
			else if(pageId.contains("3")){
				Page3 page3 = new Page3(userNode);
				pageToRef = "navOption3";
				pageMethods.combineTagStringIntoFinalString( page3.loadUsersDiv( tLoader.getHtmlStringForTag("usersDiv")));
				pageMethods.combineTagStringIntoFinalString( page3.loadUserGallons( tLoader.getHtmlStringForTag("userGallons")));
			}
				else if(pageId.contains("4")){
					Page4 page4 = new Page4(userNode);
					pageToRef = "navOption4";
					pageMethods.combineTagStringIntoFinalString( page4.loadWhatToBuy( tLoader.getHtmlStringForTag("whatToBuy")));
					pageMethods.combineTagStringIntoFinalString( page4.loadPaymentType( tLoader.getHtmlStringForTag("paymentType")));
				}
		
		JSONObject standardJObj = new JSONObject();
		 
		try {
			standardJObj.put("mainDashboardContainer",  pageMethods.finalString);
			standardJObj.put("pageId", pageToRef);
			if(pageId.equals("pg2"))standardJObj.put("body", tLoader.getHtmlStringForTag("addCCModal"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return standardJObj;	
	}
		

	
}
