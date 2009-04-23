package drawing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

abstract public class Popup {

	private static List<dataCollecting.Player> players;

	/**
	 * Used for showing message dialog.
	 * @param s = the greeting in the popup.
	 */
	static public void popupMessage(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	
	/**
	 * Used for user input, such as Name and IP number.  
	 * @param n = for ex: "Enter your name".
	 * @return = returns the string with name/ip to do something with it.
	 */
	public static String popupInput(String n){
		String input = JOptionPane.showInputDialog(n); 
		if(!input.isEmpty()) {
			return input;
		} else {
			return networking.Network.serverIP;			// Preserve the default
		}
	}

	
	/**
	 *  These two methods doesn't belong here, just for testing, didn't know where to put em.. 
	 *  createPlayers should probably be called from network, when player1 starts a new game, then 
	 *  player2 only have to call the addPlayer method.
	 *   
	 *  The for-loop that adds players in createPlayers is just for testing, popupInput should 
	 *  be called for each player somehow.
	 * @param numberOfPlayers = set to two now for testing purposes. 
	 */
	static public void createPlayers(int numberOfPlayers){
		players = new ArrayList<dataCollecting.Player>(numberOfPlayers); //array with the players

		for (int i = 0; i < numberOfPlayers; i++) //just for testing
			addPlayer(popupInput("Please enter your name: ")); 

		for(dataCollecting.Player player : players) { //test, printing just to see that it works
			player.getName();
		}

	}

	static private void addPlayer(String n){

		dataCollecting.Player player = new dataCollecting.Player(); 
		player.setName(n);				
		players.add(player);
	}

	
	static public void requestIp(){
		String newIP = popupInput("Enter your friend's IP (Ex: 192.168.0.2)");
		if (newIP != "") {
			networking.Network.serverIP = newIP;
		}
		
		//Should be called from network after the server is up and running
	}

	//TODO: String popup for insertion of PlayerName

	//TODO: IP popup for insertion of IP addresses (unless String popup handles IPs) 
		//It can if it's ok for the network to handle the ip as a string? Otherwise cast it somehow to int?

	//TODO: Choose Server/Client popup
}
