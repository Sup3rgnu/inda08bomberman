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
				networking.Network.nextKey = VK_LEFT;
			}
		}else if (c == VK_RIGHT){
			//goRight
			if (debugging ) {
				System.out.println("Local RIGHT");		//OK
				networking.Network.nextKey = VK_RIGHT;
			}
		}else if (c == VK_UP){
			//goUp
			if (debugging ) {
				System.out.println("Local UP");			//OK
				networking.Network.nextKey = VK_UP;
			}
		}else if (c == VK_DOWN){
			//goDown
			if (debugging ) {
				System.out.println("Local DOWN");		//OK
				networking.Network.nextKey = VK_DOWN;
			}
		}else if (c == SPACE){
			//dropBomb
			if (debugging ) {
				System.out.println("Local SPACE");		//OK
				networking.Network.nextKey = SPACE;
			}
		}else if (c == ESCAPE){
			//esc
			if (debugging ) {
				System.out.println("Local ESCAPE");		//OK
				networking.Network.nextKey = ESCAPE;
			}
		}else{
			//doNothing
			if (debugging ) {
				System.out.println("Local NO_KEY: byte: " + (byte) c + " char: " + (char) c);		//OK
			}
		}
	}
	
}