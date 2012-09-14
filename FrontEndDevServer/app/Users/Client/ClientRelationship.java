package Users.Client;

import org.neo4j.graphdb.RelationshipType;

public class ClientRelationship {
	public enum ClientRelationships implements RelationshipType{
		/*
		 * Properties :::
		 * grade -int
		 * price - float
		 * date_purchased - long
		 */
		CLIENT, //Client -> Vendor
		
		
		GAS_PURCHASED,//Client ->Station
		GAS_REDEEMED // Client->Station
		
	}
	
	
	
	
}
