package mapping;

public class KeyboardParser {
	public KeyboardParser() {}
	
	//public static final int VK_LEFT = 37;
	//public static final int VK_RIGHT = 227;
	//public static final int VK_UP = 38;
	//public static final int VK_DOWN = 40;
	//public static final int SPACE = 32;
	//public static final int ESCAPE = 27;
	
	public void netParse(char c) {
		if (c == (char) 37) {
			// goLeft
		}else if (c == (char) 227){
			//goRight
		}else if (c == (char) 38){
			//goUp
		}else if (c == (char) 40){
			//goDown
		}else if (c == (char) 32){
			//dropBomb
		}else if (c == (char) 27){
			//esc
		}else{
			//doNothing
		}
	}
	
	public void localParse(char c) {
		if (c == (char) 37) {
			// goLeft
		}else if (c == (char) 227){
			//goRight
		}else if (c == (char) 38){
			//goUp
		}else if (c == (char) 40){
			//goDown
		}else if (c == (char) 32){
			//dropBomb
		}else if (c == (char) 27){
			//esc
		}else{
			//doNothing
		}
	}
	
}