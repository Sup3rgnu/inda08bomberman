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
			ServerSocket serverSocket = new ServerSocket(Network.GAMEPORT);
			
			Socket server = serverSocket.accept();
			Network.handleTraffic(server);
		}
		catch (IOException e) {
           System.err.println(e);
        }
	}
}
