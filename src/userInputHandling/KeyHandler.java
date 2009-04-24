package userInputHandling;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
		
	  public synchronized void keyPressed( KeyEvent e ) {
		  //System.out.println("Local key pressed: " + e.getKeyCode());
		  //mapping.KeyboardParser parser = new mapping.KeyboardParser();		// Parser
		  //parser.localParse((byte) e.getKeyCode());
		  networking.Network.nextKey = (byte) e.getKeyCode();
	  }

	  public synchronized void keyReleased( KeyEvent e ) {
		  // Not used
	  }

	  public void keyTyped( KeyEvent e ) {
		  // Not used
	  }
}