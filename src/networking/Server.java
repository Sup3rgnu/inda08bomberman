package networking;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 * A Server connection.
 * @author caj.hofberg
 *
 */
abstract public class Server {
	/**
	 * Create a server.
	 */
	Server() {}
	
	public static void startServer() {
		try {
			System.out.println("Trying to start server");
			ServerSocket serverSocket = new ServerSocket(Network.GAMEPORT);
			
			System.out.println("Server started. Opponents may now join");
			// TODO: refresh window
			Socket server = serverSocket.accept();
			System.out.println("Connection accepted");
			
			/* Create a token */
			PrintStream networkOutput = new PrintStream(server.getOutputStream());
			networkOutput.print(Network.nullChar);
    		networkOutput.flush();			// Send one-char packets for speed
    		networkOutput = null;			// Remove
    		System.out.println("Sent a token");
			
			Network.handleTraffic(server);
		} catch (SocketException e) {
			System.err.println(e);
			drawing.Popup.popupMessage("Client disconnected");
		} catch (IOException e) {
           System.err.println(e);
           drawing.Popup.popupMessage("Failed. See System.err");
           //TODO: popup should return the exception message
        }
	}
}
