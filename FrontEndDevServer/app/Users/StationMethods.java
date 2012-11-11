package Users;

import java.util.ArrayList;
import java.util.List;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;

import scala.actors.threadpool.Arrays;

import Database.UserDatabase;

public class StationMethods {
	GraphDatabaseService uDB=UserDatabase.uDB;
	
	
	
	public boolean removePurchasedGallonsFromStationInventory(Station station, String grade, float numberOfGallons){
		try{	
			Transaction tx = uDB.beginTx();
			Node stationNode=uDB.index().forNodes("stations").get("publicId", station.publicId).getSingle();
				String[] grades = (String[]) stationNode.getProperty("gradesOfGas");
					List gradesList = Arrays.asList(grades);
					float[] amountPerGrade =(float[]) stationNode.getProperty("numberOfGallonsPerGrade");
					int index = gradesList.indexOf(grade);
					amountPerGrade[index]= amountPerGrade[index]-numberOfGallons;
					
					stationNode.setProperty("numberOfGallonsPerGrade",amountPerGrade);
			tx.success();
			tx.finish();
		}catch(RuntimeException e){
			e.printStackTrace();
		}
	return false;
	}
	/**
	 * Return the number of gallons based on the prices at station and number of dollars spent.
	 * @param dollars
	 * @param grade
	 * @param station
	 * @return
	 */
	public float convertDollarsIntoGallons(float dollars, String grade, Station station){
		float[] pricesOfGrades =station.priceOfGrade;
		String [] gradesAtStation = station.gradesOfGas;
			int indexOfGrade=-1;
		for(int i=0; i<gradesAtStation.length;i++){
			if(gradesAtStation[i].equals(grade)){
				indexOfGrade=i;
				break;
			}
		}
		if(indexOfGrade!=-1){
			float currentPriceOfGrade = pricesOfGrades[indexOfGrade];
			return dollars/currentPriceOfGrade;
		}
		else return -1;
	}
}
