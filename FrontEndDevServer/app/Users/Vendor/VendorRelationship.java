package Users.Vendor;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;

import Database.UserDatabase;

public class VendorRelationship {
	GraphDatabaseService uDB = UserDatabase.uDB;
	
	public enum VendorRelationships implements RelationshipType{
		/*
		 * Vendor -> Station Relationship
		 * properties:::
		 * date_created - long
		 */
		OWNS
	}
	/**
	 * When a vendor adds a station create the proper relationship
	 * @param vendorNode
	 * @param stationNode
	 * @return
	 */
	public Relationship connectVendorToStation(Node vendorNode ,Node stationNode){
		try{
			Transaction tx = uDB.beginTx();
			Relationship ownsRel  = vendorNode.createRelationshipTo(stationNode,  VendorRelationship.VendorRelationships.OWNS);
				ownsRel.setProperty("date_created", System.currentTimeMillis());
				
			tx.success();
			tx.finish();
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return null;
	}
	
}
