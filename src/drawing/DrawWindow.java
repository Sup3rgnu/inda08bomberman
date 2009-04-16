package drawing;

import java.awt.*;		// Includes many various classes
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;

import userInputHandling.KeyHandler;



public class DrawWindow extends JFrame {
	
	public static DrawWindow dw = new DrawWindow();
	
	private static final long serialVersionUID = 7669473739626066784L;
	
	static final int WIDTH = 768;
	static final int HEIGHT = 768;
	class Bob { int x, y, w, h, dx, dy; }
	Canvas canvas; // Our drawing component
	Vector< Point > circles = new Vector< Point >(); // Circles
	Bob bob = new Bob(); // Our rectangle
	Random rand = new Random(); // Used for random circle locations

	

	Graphics2D g2d = null;
	Graphics graphics = null;
	
	
	
	public DrawWindow() {
		
		/* Start a key listener */
		KeyHandler gameKeys = new userInputHandling.KeyHandler();
		addKeyListener(gameKeys);
		
    setIgnoreRepaint( true );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    canvas = new Canvas();
    canvas.setIgnoreRepaint( true );
    canvas.setSize( WIDTH, HEIGHT );
    add( canvas );
    pack();
    
    
    
    
 
}
    
	
	public static void DrawWindowmain() throws IOException {
	
	dw.setTitle( "Bomberman" );
	dw.setVisible( true );
	//dw.run();
  	}
}
