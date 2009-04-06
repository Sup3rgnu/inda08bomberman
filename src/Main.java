import drawing.DrawWindow;

public class Main {
	

	/**
	 * @param args
	 * @author C,M,J
	 */
	public static void main(String[] args) {
		boolean isServer = false;
		// TODO:s, format: TODO: <thing to do> (<package>, <assigned-to>
		
		
		System.out.println("Game starting");	
		
		// Just a test, not supposed to be called from here. Check out the Popup class!
		drawing.Popup.createPlayers(2); 
		drawing.Popup.requestIp(); 
		
		/* Draw the main window */
		DrawWindow.DrawWindowmain();
		
		// TODO: Initialize map (mapping, Mikael)
		// TODO: Draw the map (drawing, Jonathan)
		// TODO: Ask for IP-address(-es) in a dialog
		
		
		/* Start a server or a client */
		if (isServer) {
			networking.Server.startServer();
		} else {
			networking.Client.startClient();
		}
		
		// TODO: Change data as packets request (dataCollecting, Mikael)
		// TODO: Change map according to network packages (mapping, Mikael)
		// TODO: Draw new map alt. draw changed parts (drawing, Jonathan)
		// TODO: Collect the statistics, i.e. high score (fileHandling, Caj)
		
		// TODO: Append these todo:s to the comment above main()
		
	}

}
