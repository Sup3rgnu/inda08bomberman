package networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
	    	PrintStream networkOutput = new PrintStream(client.getOutputStream());
    		InputStreamReader userInput = new InputStreamReader(System.in);
	    	while (Network.online) {
	    		networkOutput.print(userInput.read());
	    		networkOutput.flush();			// Send one-char packets for speed
	    		if (userInput.read() == 'q') {	// Disconnect
	    			break;
	    		}
	    		userInput.reset();	// TODO: Check
	    	}
	        
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
