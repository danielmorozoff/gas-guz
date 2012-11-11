package Users;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;

import play.cache.Cache;
import play.mvc.Before;

import Database.UserDatabase;
import Users.Admin.Admin;
import Users.Client.Client;
import Users.Vendor.Vendor;

public class GenericUserMethods {
	
	/**
	 * Update nodeObject in DB. Currently written for just uDB 
	 * @param db
	 * @param oldObj
	 * @param objType
	 * @param propToChange
	 * @param newPropVal
	 * @return
	 */
	public Node updateObjectInDb(GraphDatabaseService db, Object oldObj,String objType,
			String propToChange, Object newPropVal){
	if(db.equals(UserDatabase.uDB)){	
		Object updatedObj=new Object();
		String objectId="";
		if(objType.equals("station")){
			oldObj = (Station) oldObj;
			Station updatedSObj = (Station) updatedObj;
			objectId  = updatedSObj.privateId;
		}
		else if(objType.equals("client")){
			oldObj = (Client) oldObj;
			Client updatedSObj = (Client) updatedObj;
			
			objectId  = updatedSObj.privateId;
		}
			else if(objType.equals("vendor")){
				oldObj = (Vendor) oldObj;
				Vendor updatedSObj = (Vendor) updatedObj;
				objectId  = updatedSObj.privateId;
			}
				else if(objType.equals("admin")){
					oldObj = (Admin) oldObj;
					Admin updatedSObj = (Admin) updatedObj;
					objectId  = updatedSObj.privateId;
				}
		
		Node objNode = db.index().forNodes(objType).get("privateId", objectId).getSingle();
		try{
			Transaction tx = db.beginTx();
				objNode.setProperty(propToChange,newPropVal);
			
			tx.success();
			tx.finish();
			
			return objNode;
		}catch(RuntimeException e){
			e.printStackTrace();
		}	
	}
		return null;
	}
	/**
	 * Store an Object in a database with the proper properties, 
	 * and handles the date creation/mod props.
	 * objType is used to assign an index name to the object
	 * @param db
	 * @param obj
	 * @return
	 */
	public Node storeObjectInDb(GraphDatabaseService db , Object obj, String objType){
		Node newNodeObj = null;
		if(db!=null && obj !=null){
			try{
				Transaction tx = db.beginTx();
					 newNodeObj = db.createNode();
				for(Field field: obj.getClass().getFields()){
					try {
						if(!field.getName().contains("date"))newNodeObj.setProperty(field.getName(), field.get(obj));
						//Handles dateCreated and dateModified
						else {
							newNodeObj.setProperty(field.getName(), System.currentTimeMillis());
						}
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				//Set indexes to Object
				db.index().forNodes(objType).add(newNodeObj, "privateId", newNodeObj.getProperty("privateId"));
				db.index().forNodes(objType).add(newNodeObj, "publicId", newNodeObj.getProperty("publicId"));
				
				tx.success();
				tx.finish();
			}catch(RuntimeException e){
				e.printStackTrace();
			}
		}
		return newNodeObj;
	}
	/**
	 * Set a node property in the db.
	 * @param node
	 * @param propName
	 * @param newProp
	 * @param txOutside
	 * @param db
	 * @return
	 */
	public String setNodeProperty(Node node, String propName, Object newProp,boolean txOutside, GraphDatabaseService db){
		try{
			Transaction tx=null;
			if(!txOutside && db!=null) tx= db.beginTx(); 
				if(node!=null){	
					if(node.hasProperty(propName)){
						node.setProperty(propName, newProp);
						if(!txOutside){
							tx.success();
							tx.finish();
						}
						return "propSet";
					}
					else{
						if(!txOutside && db!=null){
							tx.success();
							tx.finish();
						}
						return "propDoesNotExist";
					}
				}
				if(!txOutside && db!=null){
					tx.success();
					tx.finish();
				}
			return "nodeIsNull";
		}catch(RuntimeException e){
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * Set object properties from a map to and Object
	 * @param objectToSet
	 * @param propsToSet
	 * @return
	 */
	public Object setObjectProperties(Object objectToSet, HashMap <String, Object> propsToSet){
		for(Field field: objectToSet.getClass().getFields()){
			try {
				field.set(objectToSet, propsToSet.get(field.getName()));
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return objectToSet;
	}
	
	/**
	 * Convert userNode into a relevant object- user,Admin,Client, Vendor
	 * @param userNode
	 * @return
	 */
	public Object convertUserNodeToUserObject(Node userNode,Object uObj, ArrayList <String> listOfExceptions){
		Iterable <String> keys = userNode.getPropertyKeys();
		for (String key:keys){
			try{
				if(listOfExceptions!=null){
					if(!listOfExceptions.contains(key)){
						Field field = uObj.getClass().getField(key);
						try {
							field.set(uObj, userNode.getProperty(key));
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						} catch (IllegalAccessException e) {
							e.printStackTrace();
						}
					}
				}
				else{
					Field field = uObj.getClass().getField(key);
					
					try {
						
					if(field.isAccessible())field.set(uObj, userNode.getProperty(key));
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
			catch(NoSuchFieldException e){
				//Field not found 
			}
		}
	return uObj;
	}
	/**
	 * Get a Map of the relationship properties
	 * @param relObject
	 * @return
	 */
	public HashMap getRelationshipProperties(Relationship relObject){
		HashMap <String,Object> map = new HashMap();
			for(String key: relObject.getPropertyKeys()){
				map.put(key, relObject.getProperty(key));
			}
		return map;
	}
}
