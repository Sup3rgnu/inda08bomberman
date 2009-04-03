package networking;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;

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
			drawing.Popup.popupMessage("Trying to start client");
			client = new Socket(Network.serverIP, Network.GAMEPORT);
			drawing.Popup.popupMessage("Connected to server");
			Network.handleTraffic(client); 
	    } catch (ConnectException e) {
				System.err.println(e);
				drawing.Popup.popupMessage("Could not connect. Wrong IP?");
		} catch (SocketException e) {
			System.err.println(e);
			drawing.Popup.popupMessage("Server disconnected");
			//TODO: Enter new IP and try again
		} catch (IOException e) {
			System.err.println(e);
			drawing.Popup.popupMessage("Failed. See System.err");
		}
	}
}
