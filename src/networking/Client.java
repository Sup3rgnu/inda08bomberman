package networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
	Client() {
		Socket client;
		try {
			client = new Socket(Network.serverIP, Network.GAMEPORT);
			/* Receive messages */
			DataInputStream networkInput;
	    	networkInput = new DataInputStream(client.getInputStream());
	    	
	    	/* Send messages */
	        PrintStream networkOutput;
	        networkOutput = new PrintStream(client.getOutputStream());
	        
	        /* Close connection */
	        networkInput.close();
			networkOutput.close();
	        client.close();
	    }
		catch (IOException e) {
			System.err.println(e);
		}
	}
}
