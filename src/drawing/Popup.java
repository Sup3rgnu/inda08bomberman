package drawing;

import javax.swing.JOptionPane;

abstract public class Popup {

	static public void popupMessage(String s){
		JOptionPane.showMessageDialog(null, s);
	}
}
