package mapping;

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
	
	public void netParse(byte c) {
		if (debugging ) {
			System.out.println("mapping.netParse received char :" + Integer.toBinaryString(c));		// char c to binary string
		}
		if (c == VK_LEFT) {										//OK
			// goLeft
			if (debugging ) {
				drawing.Popup.popupMessage("Remote LEFT");
			}
		}else if (c == VK_RIGHT){								//TODO
			//goRight
			if (debugging ) {
				drawing.Popup.popupMessage("Remote RIGHT");
			}
		}else if (c == VK_UP){									//OK
			//goUp
			if (debugging ) {
				drawing.Popup.popupMessage("Remote UP");
			}
		}else if (c == VK_DOWN){								//OK
			//goDown
			if (debugging ) {
				drawing.Popup.popupMessage("Remote DOWN");
			} 
		}else if (c == SPACE){									//OK
			//dropBomb
			if (debugging ) {
				//drawing.Popup.popupMessage("Remote SPACE");
				System.out.println("Remote SPACE");
			}
		}else if (c == ESCAPE){									//OK
			//esc
			if (debugging ) {
				drawing.Popup.popupMessage("Remote ESCAPE");
			}
		}else{													//OK
			//doNothing
			if (debugging ) {
				System.out.println("Remote NO_KEY");			// May spam
			}
		}
	}
	
	public void localParse(byte c) {
		if (c == VK_LEFT) {
			// goLeft
			if (debugging ) {
				drawing.Popup.popupMessage("Local LEFT");		//OK
				networking.Network.nextKey = VK_LEFT;
			}
		}else if (c == VK_RIGHT){								//TODO
			//goRight
			if (debugging ) {
				drawing.Popup.popupMessage("Local RIGHT");
				networking.Network.nextKey = VK_RIGHT;
			}
		}else if (c == VK_UP){
			//goUp
			if (debugging ) {
				drawing.Popup.popupMessage("Local UP");			//OK
				networking.Network.nextKey = VK_UP;
			}
		}else if (c == VK_DOWN){
			//goDown
			if (debugging ) {
				drawing.Popup.popupMessage("Local DOWN");		//OK
				networking.Network.nextKey = VK_DOWN;
			}
		}else if (c == SPACE){
			//dropBomb
			if (debugging ) {
				drawing.Popup.popupMessage("Local SPACE");		//OK
				networking.Network.nextKey = SPACE;
			}
		}else if (c == ESCAPE){
			//esc
			if (debugging ) {
				drawing.Popup.popupMessage("Local ESCAPE");		//OK
				networking.Network.nextKey = ESCAPE;
			}
		}else{
			//doNothing
			if (debugging ) {
				System.out.println("Local NO_KEY: byte: " + (byte) c + " char: " + (char) c);
			}
		}
	}
	
}