package networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	Server() {
		try {
			ServerSocket serverSocket = new ServerSocket(Network.GAMEPORT);
			
			Socket server = serverSocket.accept();
			
			/* Receive messages */
			DataInputStream networkInput;
			networkInput = new DataInputStream(server.getInputStream());
			
	    	/* Send messages */
			PrintStream networkOutput;
			networkOutput = new PrintStream(server.getOutputStream());

			/* Close connection */
			networkInput.close();
			networkOutput.close();
			serverSocket.close();
			server.close();
		}
		catch (IOException e) {
           System.err.println(e);
        }
	}
}
