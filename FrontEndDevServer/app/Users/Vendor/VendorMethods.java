package Users.Vendor;

import java.util.HashMap;
import java.util.UUID;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;

import Users.GenericUserMethods;
import Users.Station;


import Database.UserDatabase;

public class VendorMethods {
	GraphDatabaseService uDB = UserDatabase.uDB;

	public boolean addStation(
			 String bussinessName,  
			 String address_street,
			 String address_city,
			 String address_state,
			 String address_zip,
			 String otherServicesOffered, Node vendorNode){
		
		HashMap map = new HashMap();
		
			map.put("bussinessName",bussinessName); 
			map.put("address_street",address_street);
			map.put("address_city",address_city);
			map.put("address_state", address_state);
			map.put("address_zip", address_zip);
			map.put("otherServicesOffered",  otherServicesOffered);
			
			map.put("publicId", UUID.randomUUID().toString());
			map.put("privateId", UUID.randomUUID().toString());
			
			GenericUserMethods genMeths = new GenericUserMethods();
			//Store  station in DB.
				Station station=  (Station) genMeths.setObjectProperties(new Station(), map);
				Node stationNode = genMeths.storeObjectInDb(uDB,station,"stations");
				if(stationNode!=null && vendorNode!=null){
					//Create Relationship between
					new VendorRelationship().connectVendorToStation(vendorNode, stationNode);
					
					
					return true;
				}
				
				
				else return false;
	}

}
