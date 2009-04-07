package mapping;

public class KeyboardParser {
	private boolean debugging = true;

	public KeyboardParser() {}
	
	private static final byte VK_LEFT = 37;
	private static final byte VK_RIGHT = (byte) 227;		// NOTE: -128 <= byte <= 127
	private static final byte VK_UP = 38;
	private static final byte VK_DOWN = 40;
	private static final byte SPACE = 32;
	private static final byte ESCAPE = 27;
	
	public void netParse(byte c) {
		if (debugging ) {
			System.out.println("mapping.netParse received char :" + Integer.toBinaryString(c));		// char c to binary string
		}
		if (c == VK_LEFT) {				//TODO
			// goLeft
			if (debugging ) {
				drawing.Popup.popupMessage("Remote LEFT");
			}
		}else if (c == VK_RIGHT){		//TODO
			//goRight
			if (debugging ) {
				drawing.Popup.popupMessage("Remote RIGHT");
			}
		}else if (c == VK_UP){			//TODO
			//goUp
			if (debugging ) {
				drawing.Popup.popupMessage("Remote UP");
			}
		}else if (c == VK_DOWN){			//TODO
			//goDown
			if (debugging ) {
				drawing.Popup.popupMessage("Remote DOWN");
			}
		}else if (c == SPACE){			// WORKS
			//dropBomb
			if (debugging ) {
				//drawing.Popup.popupMessage("Remote SPACE");
				System.out.println("Remote SPACE");
			}
		}else if (c == ESCAPE){			//TODO
			//esc
			if (debugging ) {
				drawing.Popup.popupMessage("Remote ESCAPE");
			}
		}else{									//WORKS
			//doNothing
			if (debugging ) {
				System.out.println("Remote NO_KEY");		// May spam
			}
		}
	}
	
	public void localParse(byte c) {
		if (c == VK_LEFT) {
			// goLeft
			if (debugging ) {
				drawing.Popup.popupMessage("Local LEFT");
			}
		}else if (c == VK_RIGHT){
			//goRight
			if (debugging ) {
				drawing.Popup.popupMessage("Local RIGHT");
			}
		}else if (c == VK_UP){
			//goUp
			if (debugging ) {
				drawing.Popup.popupMessage("Local UP");
			}
		}else if (c == VK_DOWN){
			//goDown
			if (debugging ) {
				drawing.Popup.popupMessage("Local DOWN");
			}
		}else if (c == SPACE){
			//dropBomb
			if (debugging ) {
				drawing.Popup.popupMessage("Local SPACE");
			}
		}else if (c == ESCAPE){
			//esc
			if (debugging ) {
				drawing.Popup.popupMessage("Local ESCAPE");
			}
		}else{
			//doNothing
			if (debugging ) {
				System.out.println("Local NO_KEY");			// May spam
			}
		}
	}
	
}