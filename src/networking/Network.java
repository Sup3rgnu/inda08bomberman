package networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

import mapping.KeyboardParser;

/**
 * Properties and functions representing the network protocol.
 * @author caj.hofberg
 *
 */
abstract public class Network {
	static final int GAMEPORT = 9889;	// Does not seem to be used
	static String serverIP;
	public static boolean online = true;
	
	Network() {}
	
	/**
	 * Once a socket has been created, this is common to both servers and clients.
	 * This method was created to have peers rather than servers/clients. Peers
	 * are preferred as the client/server solution could be unfair to one party.
	 * @param socket
	 */
	static void handleTraffic(Socket socket) {
		try {
			drawing.Popup.popupMessage("Handling traffic");
			
			/* Send messages */
			DataInputStream networkInput = new DataInputStream(socket.getInputStream());
	    	PrintStream networkOutput = new PrintStream(socket.getOutputStream());
    		InputStreamReader userInput = new InputStreamReader(System.in);
	    	while (online) {
	    		networkOutput.print(userInput.read());
	    		networkOutput.flush();			// Send one-char packets for speed
	    		drawing.Popup.popupMessage("Sent a package");
	    		if (userInput.read() == 'q') {	// Disconnect
	    			drawing.Popup.popupMessage("Disconnected");
	    			break;
	    		} else {
	    			/* Receive messages  - what does our opponent do? */
	    			KeyboardParser parser = new KeyboardParser();
	    			parser.netParse((char) userInput.read());	// NOTE: Cast!
	    		}
	    		userInput.reset();	// TODO: Check if it works
	    	}
	        
	        /* Close connection */
	    	drawing.Popup.popupMessage("Closing connection");
	        networkInput.close();
			networkOutput.close();
	        socket.close();
	    } catch (IOException e) {
			System.err.println(e);
			drawing.Popup.popupMessage("IO Exception");
		}
	}
}