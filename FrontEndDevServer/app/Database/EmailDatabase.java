package Database;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class EmailDatabase {
public static GraphDatabaseService eDB ;
	public EmailDatabase(){
		eDB= new EmbeddedGraphDatabase("GasGuzDatabases/EmailDatabase");
		registerShutdownHook(eDB);
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
	        	eDB.shutdown();
	        }
	    } );
	}
}
