package drawing;

import java.awt.*;		// Includes many various classes
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import userInputHandling.KeyHandler;

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
    
    
    bob.x = bob.y = 250;
    bob.dx = bob.dy = 25;
    bob.w = bob.h = 25;
    
    }
	
	public void run() throws IOException {
  
    canvas.createBufferStrategy( 2 );
    BufferStrategy buffer = canvas.getBufferStrategy();
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    GraphicsConfiguration gc = gd.getDefaultConfiguration();
    BufferedImage bi = gc.createCompatibleImage( WIDTH, HEIGHT );
    
    Graphics graphics = null;
    Graphics2D g2d = null;
    Color background = Color.PINK;
    
    
      try {
      
       
        
        // Clear the back buffer          
        g2d = bi.createGraphics();
        g2d.setColor( background );
        g2d.fillRect( 0, 0, WIDTH, HEIGHT );
        
        // Draw help
        g2d.setColor(  Color.BLACK );
        
        g2d.drawString( "--------------------------", 250, 200 );
        g2d.drawString( "New Game", 250, 210 );
        g2d.drawString( "Bomberman.exe", 250, 220 );
        g2d.drawString( "Press Q to disconnect", 250, 230 );
        g2d.drawString( "--------------------------", 250, 240 );

        // Cajs tester
        //Image test = Toolkit.getDefaultToolkit().getImage("bombe/bombe0.gif");
        Image test = ImageIO.read(new File("bombe/bombe0.gif"));
        g2d.drawImage(test, 32, 32, 32, 32, this);

        // Draw random circles
        g2d.setColor( Color.BLACK );
        for( Point p : circles ) {
          g2d.drawOval( p.x, p.y, 25, 25 );
          g2d.drawOval( p.x, p.y, 50, 50 );
          g2d.drawOval( p.x, p.y, 100, 100 );
          g2d.drawOval( p.x, p.y, 150, 150 );
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
		
	public static void DrawWindowmain() throws IOException {
	DrawWindow dw = new DrawWindow();
	dw.setTitle( "Bomberman" );
	dw.setVisible( true );
	dw.run();
    
  	}
}
