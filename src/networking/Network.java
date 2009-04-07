package networking;

import java.io.DataInputStream;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.SocketException;

/**
 * Properties and functions representing the network protocol.
 * Filter for capturing traffic using Wireshark:
 * (tcp.dstport == 9889) || (tcp.srcport == 9889)
 * 
 * Same filter without nullchars:
 * (tcp.dstport == 9889) || (tcp.srcport == 9889) && !(data.data == 61)			//For nullchar = 'a'
 * @author caj.hofberg
 *
 */
abstract public class Network {
	static final int GAMEPORT = 9889;	// Does not seem to be used
	public static String serverIP = "192.168.1.143";
	public static boolean online = true;
	
	public static byte nullChar = 'a';		// For no key pressed this time
	public static byte nextKey = nullChar;	// No key pressed yet
	
	Network() {}
	
	/**
	 * Once a socket has been created, this is common to both servers and clients.
	 * This method was created to have peers rather than servers/clients. Peers
	 * are preferred as the client/server solution could be unfair to one party.
	 * @param socket
	 */
	static void handleTraffic(Socket socket) {
		try {
			System.out.println("Handling traffic");
			
			// Network in/out
			DataInputStream networkInput = new DataInputStream(socket.getInputStream());
	    	PrintStream networkOutput = new PrintStream(socket.getOutputStream());
	    	
	    	// Keyboard stream
    		//InputStreamReader userInput = new InputStreamReader(System.in);
    		
    		// Parser for chars
    		mapping.KeyboardParser parser = new mapping.KeyboardParser();
    		
    		/* Send & receive messages */
	    	while (online) {
	    		/* Receive messages  - what does our opponent do? */
    			
    			byte incomingChar = (byte) networkInput.read();		// readChar() did wrong
    			if (incomingChar != nullChar) {
    				parser.netParse(incomingChar);
    			} else {
    				// Don't care
    				//System.out.println("Received nullchar: " + incomingChar);
    			}
    			
    			// We got the token!
    			// TCP makes sure that the token is not lost
    			
    			/* Now it is time to send */
    			//nextKey = (char) userInput.read();
    			if (nextKey != nullChar) {
    				System.out.println("User pressed int: " + nextKey + "char: " + (char) nextKey);
    			}
	    		networkOutput.print(nextKey);
	    		networkOutput.flush();			// Send one-char packets for speed
	    		nextKey = nullChar;
	    		//System.out.println("Sent a package");
	    		if (nextKey == (char) 81 || nextKey == (char) 113) {		
	    			/* Disconnect */
	    			drawing.Popup.popupMessage("Disconnected");
	    			online = false;		
	    			break;				// Not necessary with the online boolean
	    		} else {
	    			// Continue
	    		}
	    	}
	        
	        /* Close connection */
	    	drawing.Popup.popupMessage("Closing connection");
	        networkInput.close();
			networkOutput.close();
	        socket.close();
		} catch (SocketException e) {
			System.err.println(e);
			drawing.Popup.popupMessage("Disconnected");
			//TODO: Enter new IP and try again
	    } catch (IOException e) {
			System.err.println(e);
			drawing.Popup.popupMessage("IO Exception");
		}
	}
}