package drawing;

import javax.swing.JOptionPane;

abstract public class Popup {

	static public void popupMessage(){
		JOptionPane.showMessageDialog(null, "You win!");
	}
}
