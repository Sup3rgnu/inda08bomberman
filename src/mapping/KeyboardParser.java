package mapping;

import java.awt.event.KeyEvent;

/**
 * byte appeared to be better than char due to unicode troubles
 * @author 
 *
 */
public class KeyboardParser {
	private boolean debugging = true;

	public KeyboardParser() {}
	
	private static final byte VK_LEFT = 37;
	private static final byte VK_RIGHT = 39;
	private static final byte VK_UP = 38;
	private static final byte VK_DOWN = 40;
	private static final byte SPACE = 32;
	private static final byte ESCAPE = 27;
	private static final byte VK_Q = (byte) KeyEvent.VK_Q;
	
	public void netParse(byte c) {
		if (debugging ) {
			System.out.println("mapping.netParse received char :" + Integer.toBinaryString(c));		// char c to binary string
		}
		if (c == VK_LEFT) {										//OK
			// goLeft
			if (debugging ) {
				System.out.println("Remote LEFT");
			}
		}else if (c == VK_RIGHT){								//OK
			//goRight
			if (debugging ) {
				System.out.println("Remote RIGHT");
			}
		}else if (c == VK_UP){									//OK
			//goUp
			if (debugging ) {
				System.out.println("Remote UP");
			}
		}else if (c == VK_DOWN){								//OK
			//goDown
			if (debugging ) {
				System.out.println("Remote DOWN");
			} 
		}else if (c == SPACE){									//OK
			//dropBomb
			if (debugging ) {
				System.out.println("Remote SPACE");
			}
		}else if (c == ESCAPE){									//OK
			//esc
			if (debugging ) {
				System.out.println("Remote ESCAPE");
			}
		}else if (c == VK_Q){									//TODO test
			//disconnect
			if (debugging) {
				System.out.println("Remote DISCONNECT");
			}
		}else{													//OK
			//doNothing
			if (debugging ) {
				System.out.println("Remote NO_KEY");			// May spam			//OK
			}
		}
	}
	
	public void localParse(byte c) {
		if (c == VK_LEFT) {
			// goLeft
			if (debugging ) {
				System.out.println("Local LEFT");		//OK
			}
			networking.Network.nextKey = VK_LEFT;
			mapping.Movement.goLeft();
		}else if (c == VK_RIGHT){
			//goRight
			if (debugging ) {
				System.out.println("Local RIGHT");		//OK
			}
			networking.Network.nextKey = VK_RIGHT;
			mapping.Movement.goRight();
		}else if (c == VK_UP){
			//goUp
			if (debugging ) {
				System.out.println("Local UP");			//OK
			}
			networking.Network.nextKey = VK_UP;
			mapping.Movement.goUp();
		}else if (c == VK_DOWN){
			//goDown
			if (debugging ) {
				System.out.println("Local DOWN");		//OK
			}
			networking.Network.nextKey = VK_DOWN;
			mapping.Movement.goDown();
		}else if (c == SPACE){
			//dropBomb
			if (debugging ) {
				System.out.println("Local SPACE");		//OK
			}
			networking.Network.nextKey = SPACE;
		}else if (c == ESCAPE){
			//esc
			if (debugging ) {
				System.out.println("Local ESCAPE");		//OK
			}
			networking.Network.nextKey = ESCAPE;
		}else if (c == VK_Q){
			//disconnect
			if (debugging ) {
				System.out.println("Local DISCONNECT");	//OK
			}
			networking.Network.nextKey = VK_Q;
		}else{
			//doNothing
			if (debugging ) {
				System.out.println("No such key: byte: " + (byte) c + " char: " + (char) c);		//OK
			}
		}
	}
}