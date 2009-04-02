package networking;

import java.io.IOException;
import java.net.Socket;
import networking.Network;

/**
 * A client connection.
 * @author caj.hofberg
 *
 */
public class Client {
	Client() {}
	
	static public void startClient() {
		Socket client;
		try {
			client = new Socket(Network.serverIP, Network.GAMEPORT);
			Network.handleTraffic(client);
	    }
		catch (IOException e) {
			System.err.println(e);
		}
	}
}
