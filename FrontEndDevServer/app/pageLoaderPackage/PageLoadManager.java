package pageLoaderPackage;

import org.neo4j.shell.util.json.JSONException;
import org.neo4j.shell.util.json.JSONObject;

public class PageLoadManager {
	
	public JSONObject loadPage(String pageId){
		
		String pageToRef= "";
		
		TagLoader tLoader = new TagLoader(pageId);
		
		String fullTagString ="";
		System.out.println("PAGEId: "+pageId);
		//Order of tags matters
		if(pageId.contains("1")){
			pageToRef = "navOption1";
			fullTagString += tLoader.getHtmlStringForTag("stationsTag");
			fullTagString += tLoader.getHtmlStringForTag("consumpStatsTag");
		}
		else if(pageId.contains("2")){
			pageToRef = "navOption2";
			fullTagString += tLoader.getHtmlStringForTag("personalInfo");
			fullTagString += tLoader.getHtmlStringForTag("paymentMeth");
			fullTagString += tLoader.getHtmlStringForTag("accountStats");
		}
			else if(pageId.contains("3")){
				pageToRef = "navOption3";
			
				fullTagString += tLoader.getHtmlStringForTag("usersDiv");
				fullTagString += tLoader.getHtmlStringForTag("userGallons");
			}
				else if(pageId.contains("4")){
					pageToRef = "navOption4";
					fullTagString += tLoader.getHtmlStringForTag("whatToBuy");
					fullTagString += tLoader.getHtmlStringForTag("paymentType");
				}
		
		JSONObject standardJObj = new JSONObject();
		 
		try {
			standardJObj.put("mainDashboardContainer", fullTagString );
			standardJObj.put("pageId", pageToRef);
			if(pageId.equals("pg2"))standardJObj.put("body", tLoader.getHtmlStringForTag("addCCModal"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return standardJObj;	
	}
		

	
}
