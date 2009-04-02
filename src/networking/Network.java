package networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

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
			/* Receive messages */
			DataInputStream networkInput;
	    	networkInput = new DataInputStream(socket.getInputStream());
	    	
			/* Send messages */
	    	PrintStream networkOutput = new PrintStream(socket.getOutputStream());
    		InputStreamReader userInput = new InputStreamReader(System.in);
	    	while (Network.online) {
	    		networkOutput.print(userInput.read());
	    		networkOutput.flush();			// Send one-char packets for speed
	    		if (userInput.read() == 'q') {	// Disconnect
	    			break;
	    		}
	    		userInput.reset();	// TODO: Check if it works
	    	}
	        
	        /* Close connection */
	        networkInput.close();
			networkOutput.close();
	        socket.close();
	    } catch (IOException e) {
			System.err.println(e);
		}
	}
}