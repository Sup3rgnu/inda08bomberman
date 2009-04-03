package drawing;

import javax.swing.JOptionPane;

abstract public class Popup {

	static public void popupMessage(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	
	//TODO: String popup for insertion of PlayerName
	
	//TODO: IP popup for insertion of IP addresses (unless String popup handles IPs)
	
	//TODO: Choose Server/Client popup
}