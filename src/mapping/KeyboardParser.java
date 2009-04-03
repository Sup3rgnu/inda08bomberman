package mapping;

public class KeyboardParser {
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
		}else if (c == (char) VK_RIGHT){
			//goRight
		}else if (c == (char) VK_UP){
			//goUp
		}else if (c == (char) VK_DOWN){
			//goDown
		}else if (c == (char) SPACE){
			//dropBomb
		}else if (c == (char) ESCAPE){
			//esc
		}else{
			//doNothing
		}
	}
	
	public void localParse(char c) {
		if (c == (char) VK_LEFT) {
			// goLeft
		}else if (c == (char) VK_RIGHT){
			//goRight
		}else if (c == (char) VK_UP){
			//goUp
		}else if (c == (char) VK_DOWN){
			//goDown
		}else if (c == (char) SPACE){
			//dropBomb
		}else if (c == (char) ESCAPE){
			//esc
		}else{
			//doNothing
		}
	}
	
}