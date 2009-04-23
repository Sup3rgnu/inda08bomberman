import java.io.IOException;

import drawing.DrawWindow;

public class Main {
	

	/**
	 * @param args
	 * @author C,M,J
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO:s, format: TODO: <thing to do> (<package>, <assigned-to>
		
		
		System.out.println("Game starting");	
		
		// Just a test, not supposed to be called from here. Check out the Popup class!
		
		drawing.Popup.createPlayers(1); 
		drawing.Popup.requestIp(); 
		mapping.Map.startMap();
		DrawWindow.DrawWindowmain();
		
		// TODO: Initialize map (mapping, Mikael)
		
		// TODO: Draw the map (drawing, Jonathan)
		// TODO: Ask for IP-address(-es) in a dialog

			
		
		/* Start a server or a client */
		if (networking.Network.isServer) {
			mapping.Map.board[1][1] = mapping.Map.PLAYER1;
			mapping.Map.board[mapping.Map.HEIGHT-2][mapping.Map.WIDTH-2] = mapping.Map.PLAYER2;
			mapping.Map.drawBoard();
			networking.Server.startServer();
		} else {
			mapping.Map.board[1][1] = mapping.Map.PLAYER2;
			mapping.Map.board[mapping.Map.HEIGHT-2][mapping.Map.WIDTH-2] = mapping.Map.PLAYER1;
			mapping.Map.PLAYERPOSY = mapping.Map.HEIGHT-2;
			mapping.Map.PLAYERPOSX = mapping.Map.WIDTH-2;
			mapping.Map.PLAYER2POSY = 1;
			mapping.Map.PLAYER2POSX = 1;
			mapping.Map.drawBoard();
			networking.Client.startClient();
		}
		
		
		// TODO: Change data as packets request (dataCollecting, Mikael)
		// TODO: Change map according to network packages (mapping, Mikael)
		// TODO: Draw new map alt. draw changed parts (drawing, Jonathan)
		// TODO: Collect the statistics, i.e. high score (fileHandling, Caj)
		
		// TODO: Append these todo:s to the comment above main()
		
	}

}
