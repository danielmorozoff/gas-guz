package Users.Client;

import java.util.HashMap;
import java.util.UUID;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import Users.GenericUserMethods;
import Users.Station;
import Users.StationMethods;

import Database.TransactionDatabase;
import Database.UserDatabase;

public class ClientMethods {
	GraphDatabaseService uDB = UserDatabase.uDB;
	GraphDatabaseService tDB = TransactionDatabase.tDB;
	
	/**
	 * Add Client to db.
	 * @param fName
	 * @param lName
	 * @param username
	 * @param password
	 * @param email
	 * @param phone
	 * @param status
	 * @return
	 */
	public boolean addClient(
			String fName, 
			String lName,
			String username,
			String password,
			String email,
			String phone, 
			String status){
		
		HashMap map = new HashMap();
		
		map.put("fName",fName); 
		map.put("lName",lName);
		map.put("username",username);
		map.put("password", password);
		map.put("email", email);
		map.put("phone",  phone);
		map.put("status",status);
		
		map.put("publicId", UUID.randomUUID().toString());
		map.put("privateId", UUID.randomUUID().toString());
		
		GenericUserMethods genMeths = new GenericUserMethods();
		//Store  Client in DB.
			Client client=  (Client) genMeths.setObjectProperties(new Client(), map);
			if(genMeths.storeObjectInDb(uDB,client,"clients")!=null) return true;
			else return false;
	}
	/**
	 * User pruchases gasoline form a specific station
	 * @param pubStationId
	 * @param pubClientId
	 * @param amountOfDollars
	 * @return
	 */
	public Relationship purchaseGas( String pubStationId, String pubClientId, String grade, float amountOfDollars){
		Node stationNode = uDB.index().forNodes("stations").get("publicId", pubStationId).getSingle();
		Node clientNode = uDB.index().forNodes("clients").get("publicId", pubClientId).getSingle();
		if(clientNode!=null && stationNode!=null ){
			try{	
				Transaction tx = uDB.beginTx();
					Relationship purchasedRel = clientNode.createRelationshipTo(stationNode, ClientRelationship.ClientRelationships.GAS_PURCHASED);
					purchasedRel.setProperty("grade", grade);
					purchasedRel.setProperty("amountOfDollars", amountOfDollars);
					//convert dollars to gallons
					StationMethods sMeths = new StationMethods();
					Station station = (Station)new GenericUserMethods().convertUserNodeToUserObject(stationNode, new Station(), null);
					float numberOfGallons = sMeths.convertDollarsIntoGallons(amountOfDollars,grade,
							station);
					purchasedRel.setProperty("amountOfGallons",numberOfGallons);
							
					purchasedRel.setProperty("date_purchased", System.currentTimeMillis());
				
				//Modify the number of Gallons stored at the station accordingly
					sMeths.removePurchasedGallonsFromStationInventory(station, grade, numberOfGallons);
					
					
				tx.success();
				tx.finish();
				
				
			}catch(RuntimeException e){
				e.printStackTrace();
			}
		}
		return null;
	}
	
}
