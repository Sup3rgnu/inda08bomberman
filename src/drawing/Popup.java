package drawing;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

abstract public class Popup {

	private static List<dataCollecting.Player> players;

	static public void popupMessage(String s){
		JOptionPane.showMessageDialog(null, s);
	}

	static private void popupInput(String n){

		String inputName = JOptionPane.showInputDialog(n); 
		addPlayer(inputName);
	}

	/**
	 *  These two methods doesn't belong here, just for testing, didn't know where to put em.. 
	 *  Should probably be called from network, and the for-loop that adds players in createPlayers
	 *  is just for testing, popupInput should be called for each player somehow.
	 * @param numberOfPlayers
	 */

	static public void createPlayers(int numberOfPlayers){
		players = new ArrayList<dataCollecting.Player>(numberOfPlayers);

		for (int i = 0; i < numberOfPlayers; i++)
			drawing.Popup.popupInput("Please enter your name: "); 

		for(dataCollecting.Player player : players) {
			player.getName();
		}

	}

	static private void addPlayer(String n){

		dataCollecting.Player player = new dataCollecting.Player(); 
		player.setName(n);				
		players.add(player);
	}


	//TODO: String popup for insertion of PlayerName

	//TODO: IP popup for insertion of IP addresses (unless String popup handles IPs)

	//TODO: Choose Server/Client popup
}
