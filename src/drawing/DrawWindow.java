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
	
	public static DrawWindow dw = new DrawWindow();
	
	private static final long serialVersionUID = 7669473739626066784L;
	
	static final int WIDTH = 16*32;
	static final int HEIGHT = 16*32;
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
    
    Graphics graphics = getGraphics();
    Graphics2D g2d = (Graphics2D) getGraphics();
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
         
        Image crate = ImageIO.read(new File("graphics/crate.gif"));
        Image stone = ImageIO.read(new File("graphics/stone.gif"));
        Image grass = ImageIO.read(new File("graphics/grass.gif"));
        Image player1 = ImageIO.read(new File("graphics/player1.gif"));
        Image player2 = ImageIO.read(new File("graphics/player2.gif"));
        		
        
	        	
		for(int j=0; j <mapping.Map.HEIGHT; j++){
			for(int i=0; i < mapping.Map.WIDTH; i++){
				if(mapping.Map.board[j][i] == mapping.Map.UNBREAKABLE){
					g2d.drawImage(stone, i*32, j*32, 32, 32,this);
				} else if(mapping.Map.board[j][i] == mapping.Map.FREE){
					g2d.drawImage(grass, i*32, j*32, 32, 32,this);
				} else if(mapping.Map.board[j][i] == mapping.Map.PLAYER1){
					g2d.drawImage(player1, i*32, j*32, 32, 32,this);
				} else if(mapping.Map.board[j][i] == mapping.Map.PLAYER2){
					g2d.drawImage(player2, i*32, j*32, 32, 32,this);
				} else if(mapping.Map.board[j][i] == mapping.Map.STONE){
					g2d.drawImage(crate, i*32, j*32, 32, 32,this);
				}
			}
			System.out.println();
		}
		//g2d.drawImage(crate, 0, 0, 32, 32,this);
        
     
        // Blit image and flip...
        graphics = buffer.getDrawGraphics();
        graphics.drawImage(bi, 0, 0, this);
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
	
	dw.setTitle( "Bomberman" );
	dw.setVisible( true );
	dw.run();
  	}
}
