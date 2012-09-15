package Database;

import java.io.File;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class UserDatabase {
	static public GraphDatabaseService uDB;
	public UserDatabase(){
		File folder = new File("GasGuzDatabases");
		if(!folder.exists())folder.mkdirs();
		uDB = new EmbeddedGraphDatabase("GasGuzDatabases/UserDatabase");
		registerShutdownHook(uDB);
	}
	private static void registerShutdownHook( final GraphDatabaseService graphDb )
	{
	    // Registers a shutdown hook for the Neo4j instance so that it
	    // shuts down nicely when the VM exits (even if you "Ctrl-C" the
	    // running example before it's completed)
	    Runtime.getRuntime().addShutdownHook( new Thread()
	    {
	        @Override
	        public void run()
	        {
	        	System.out.println("Shutting down EmailDB");
	        	uDB.shutdown();
	        }
	    } );
	}
	
	
	
}
