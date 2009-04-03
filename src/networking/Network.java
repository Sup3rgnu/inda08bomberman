package networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * Properties and functions representing the network protocol.
 * @author caj.hofberg
 *
 */
abstract public class Network {
	static final int GAMEPORT = 9889;	// Does not seem to be used
	static String serverIP = "192.168.1.143";
	public static boolean online = true;
	
	private static char nullChar = 'a';		// For no key pressed this time
	public static char nextKey = nullChar;	// No key pressed yet
	
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
			
			// Network in/out
			DataInputStream networkInput = new DataInputStream(socket.getInputStream());
	    	PrintStream networkOutput = new PrintStream(socket.getOutputStream());
	    	
	    	// Keyboard stream
    		//InputStreamReader userInput = new InputStreamReader(System.in);
    		
    		/* Send & receive messages */
	    	while (online) {
	    		networkOutput.print(nextKey);
	    		networkOutput.flush();			// Send one-char packets for speed
	    		drawing.Popup.popupMessage("Sent a package");
	    		if (nextKey == 0) {		//TODO: should be q/Q
	    			/* Disconnect */
	    			drawing.Popup.popupMessage("Disconnected");
	    			online = false;		
	    			break;				// Not necessary with the online boolean
	    		} else {
	    			/* Receive messages  - what does our opponent do? */
	    			mapping.KeyboardParser parser = new mapping.KeyboardParser();
	    			char incomingChar = networkInput.readChar();
	    			if (incomingChar != nullChar) {
	    				parser.netParse(incomingChar);
	    			} else {
	    				// Don't care
	    				drawing.Popup.popupMessage("Received: " + incomingChar);
	    			}
	    		}
	    	}
	        
	        /* Close connection */
	    	drawing.Popup.popupMessage("Closing connection");
	        networkInput.close();
			networkOutput.close();
	        socket.close();
		} catch (SocketException e) {
			System.err.println(e);
			drawing.Popup.popupMessage("Server disconnected");
			//TODO: Enter new IP and try again
	    } catch (IOException e) {
			System.err.println(e);
			drawing.Popup.popupMessage("IO Exception");
		}
	}
}