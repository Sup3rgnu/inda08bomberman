package mapping;

public class KeyboardParser {
	private boolean debugging = true;

	public KeyboardParser() {}
	
	private static final int VK_LEFT = 37;
	private static final int VK_RIGHT = 227;
	private static final int VK_UP = 38;
	private static final int VK_DOWN = 40;
	private static final int SPACE = 32;
	private static final int ESCAPE = 27;
	
	public void netParse(char c) {
		if (c == (char) VK_LEFT) {
			// goLeft
			if (debugging ) {
				drawing.Popup.popupMessage("Remote LEFT");
			}
		}else if (c == (char) VK_RIGHT){
			//goRight
			if (debugging ) {
				drawing.Popup.popupMessage("Remote RIGHT");
			}
		}else if (c == (char) VK_UP){
			//goUp
			if (debugging ) {
				drawing.Popup.popupMessage("Remote UP");
			}
		}else if (c == (char) VK_DOWN){
			//goDown
			if (debugging ) {
				drawing.Popup.popupMessage("Remote DOWN");
			}
		}else if (c == (char) SPACE){
			//dropBomb
			if (debugging ) {
				drawing.Popup.popupMessage("Remote SPACE");
			}
		}else if (c == (char) ESCAPE){
			//esc
			if (debugging ) {
				drawing.Popup.popupMessage("Remote ESCAPE");
			}
		}else{
			//doNothing
			if (debugging ) {
				System.out.println("Remote NO_KEY");		// May spam
			}
		}
	}
	
	public void localParse(char c) {
		if (c == (char) VK_LEFT) {
			// goLeft
			if (debugging ) {
				drawing.Popup.popupMessage("Local LEFT");
			}
		}else if (c == (char) VK_RIGHT){
			//goRight
			if (debugging ) {
				drawing.Popup.popupMessage("Local RIGHT");
			}
		}else if (c == (char) VK_UP){
			//goUp
			if (debugging ) {
				drawing.Popup.popupMessage("Local UP");
			}
		}else if (c == (char) VK_DOWN){
			//goDown
			if (debugging ) {
				drawing.Popup.popupMessage("Local DOWN");
			}
		}else if (c == (char) SPACE){
			//dropBomb
			if (debugging ) {
				drawing.Popup.popupMessage("Local SPACE");
			}
		}else if (c == (char) ESCAPE){
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