package networking;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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
			drawing.Popup.popupMessage("Trying to start server");
			ServerSocket serverSocket = new ServerSocket(Network.GAMEPORT);
			
			Socket server = serverSocket.accept();
			drawing.Popup.popupMessage("Connection accepted");
			Network.handleTraffic(server);
		}
		catch (IOException e) {
           System.err.println(e);
        }
	}
}
