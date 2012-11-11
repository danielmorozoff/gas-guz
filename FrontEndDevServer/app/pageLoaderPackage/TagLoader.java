package pageLoaderPackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.neo4j.graphdb.Node;


public class TagLoader {
	String pageToLoad;
	public TagLoader(String pageToLoad){
		this.pageToLoad = pageToLoad;
	}
	
	public String getHtmlStringForTag(String tagName){
		File tagFile = new File("FrontEndDevServer/app/views/tags/dashboardTags/"+pageToLoad+"/"+tagName+".html");
		String tagString = "";
		System.out.println("File:"+tagFile.getAbsolutePath());
		if(tagFile.exists()){
			try {
				String sCurrentLine;
				BufferedReader iReader = new BufferedReader(new FileReader(tagFile));
				while((sCurrentLine = iReader.readLine()) != null){
					tagString+=sCurrentLine;
				}
				iReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return tagString;
	}
}
