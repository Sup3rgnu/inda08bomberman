package drawing;

import java.awt.*;		// Includes many various classes
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

import javax.swing.JFrame;

public class DrawWindow extends JFrame {

	private static final long serialVersionUID = 7669473739626066784L;
	static final int WIDTH = 640;
	static final int HEIGHT = 480;
	class Bob { int x, y, w, h, dx, dy; }
	Canvas canvas; // Our drawing component
	Vector< Point > circles = new Vector< Point >(); // Circles
	Bob bob = new Bob(); // Our rectangle
	Random rand = new Random(); // Used for random circle locations

	public DrawWindow() {
  
    setIgnoreRepaint( true );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    canvas = new Canvas();
    canvas.setIgnoreRepaint( true );
    canvas.setSize( WIDTH, HEIGHT );
    add( canvas );
    pack();
    
    
    
    bob.x = bob.y = 0;
    bob.dx = bob.dy = 5;
    bob.w = bob.h = 25;
    }
	
	public void run() {
  
    canvas.createBufferStrategy( 2 );
    BufferStrategy buffer = canvas.getBufferStrategy();
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    GraphicsConfiguration gc = gd.getDefaultConfiguration();
    BufferedImage bi = gc.createCompatibleImage( WIDTH, HEIGHT );
    
    Graphics graphics = null;
    Graphics2D g2d = null;
    Color background = Color.BLACK;
    
    while( true ) {
      try {
      
       
        
        // Clear the back buffer          
        g2d = bi.createGraphics();
        g2d.setColor( background );
        g2d.fillRect( 0, 0, WIDTH, HEIGHT );
        
        // Draw help
        g2d.setColor(  Color.GREEN );
        g2d.drawString( "Use arrow keys to move rect", 20, 20 );
        g2d.drawString( "Press SPACE to add circles", 20, 32 );
        g2d.drawString( "Press C to clear circles", 20, 44 );
        g2d.drawString( "Press ESC to exit", 20, 56 );
               
        // Draw random circles
        g2d.setColor( Color.MAGENTA );
        for( Point p : circles ) {
          g2d.drawOval( p.x, p.y, 25, 25 );
        }
        
        // Draw bob
        g2d.setColor(  Color.GREEN );
        g2d.drawRect( bob.x, bob.y, bob.w, bob.h );
        
        // Blit image and flip...
        graphics = buffer.getDrawGraphics();
        graphics.drawImage( bi, 0, 0, null );
        if( !buffer.contentsLost() )
          buffer.show();
          
        // Let the OS have a little time...
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        
      } finally {
        // Release resources
        if( graphics != null ) 
          graphics.dispose();
        if( g2d != null ) 
          g2d.dispose();
      	}
    }
	}

	
	public static void DrawWindowmain() {
	DrawWindow dw = new DrawWindow();
	dw.setTitle( "Simple Keyboard Input" );
	dw.setVisible( true );
	dw.run();
    
  	}
}
