package networking;

import java.io.IOException;
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
			drawing.Popup.popupMessage("Trying to start server");
			ServerSocket serverSocket = new ServerSocket(Network.GAMEPORT);
			
			drawing.Popup.popupMessage("Server started. Opponents may now join");
			// TODO: refresh window
			Socket server = serverSocket.accept();
			drawing.Popup.popupMessage("Connection accepted");
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
