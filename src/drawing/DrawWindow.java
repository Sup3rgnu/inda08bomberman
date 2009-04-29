package drawing;

import java.awt.*;		// Includes many various classes
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import userInputHandling.KeyHandler;


/**
 * The class DrawWidnow creates the graphic window to the game.
 * It draws a canvas window and all the textures.
 */
public class DrawWindow extends JFrame {
	
	public static DrawWindow dw = new DrawWindow();
	
	private static final long serialVersionUID = 7669473739626066784L;
	
	static final int WIDTH = 16*32;
	static final int HEIGHT = 16*32;
	
	Canvas canvas; // Our drawing component
	
	/**
	 * The constructor.
	 * Draw the canvas window.
	 */
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
	/**
	 * Draw the canvas background color and all the textures for the Map.
	 * @throws IOException
	 */
	public void run() throws IOException {
  
    canvas.createBufferStrategy( 2 );
    BufferStrategy buffer = canvas.getBufferStrategy();
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    GraphicsConfiguration gc = gd.getDefaultConfiguration();
    BufferedImage bi = gc.createCompatibleImage( WIDTH, HEIGHT );
    
    Graphics graphics = getGraphics();
    Graphics2D g2d = (Graphics2D) getGraphics();
    Color background = Color.GREEN.darker(); //Canvas background color.
    
    
      try {
      
        // Clear the back buffer          
        g2d = bi.createGraphics();
        g2d.setColor( background );
        g2d.fillRect( 0, 0, WIDTH, HEIGHT );
        
         
        Image crate = ImageIO.read(new File("graphics/crate.gif"));
        Image stone = ImageIO.read(new File("graphics/stone.bmp"));
        //Image grass = ImageIO.read(new File("graphics/grass.gif"));
        Image player1 = ImageIO.read(new File("graphics/player1.bmp"));
        Image player2 = ImageIO.read(new File("graphics/player2.bmp"));
        Image bomb1 = ImageIO.read(new File("graphics/bomb1.bmp"));
        Image bomb2 = ImageIO.read(new File("graphics/bomb2.bmp"));
       	Image playerandbomb = ImageIO.read(new File("graphics/bomb1.bmp"));
        Image playerandbomb2 = ImageIO.read(new File("graphics/bomb2.bmp"));
        Image explosion = ImageIO.read(new File("graphics/explosion.bmp"));
        
        //Check all the raws and columns in the Map and draw the texture.
		for(int j=0; j <mapping.Map.HEIGHT; j++){
			for(int i=0; i < mapping.Map.WIDTH; i++){
				if(mapping.Map.board[j][i] == mapping.Map.UNBREAKABLE){
					g2d.drawImage(stone, i*32, j*32, 32, 32,this);
				//} else if(mapping.Map.board[j][i] == mapping.Map.FREE){
				//	g2d.drawImage(grass, i*32, j*32, 32, 32,this);
				} else if(mapping.Map.board[j][i] == mapping.Map.PLAYER1){
					g2d.drawImage(player1, i*32, j*32, 32, 32,this);
				} else if(mapping.Map.board[j][i] == mapping.Map.PLAYER2){
					g2d.drawImage(player2, i*32, j*32, 32, 32,this);
				} else if(mapping.Map.board[j][i] == mapping.Map.CRATE){
					g2d.drawImage(crate, i*32, j*32, 32, 32,this);
				} else if(mapping.Map.board[j][i] == mapping.Map.BOMB1){
					g2d.drawImage(bomb1, i*32, j*32, 32, 32,this);
				} else if(mapping.Map.board[j][i] == mapping.Map.BOMB2){
					g2d.drawImage(bomb2, i*32, j*32, 32, 32,this);
				} else if(mapping.Map.board[j][i] == mapping.Map.PLAYERANDBOMB){
					g2d.drawImage(playerandbomb, i*32, j*32, 32, 32,this);
				} else if(mapping.Map.board[j][i] == mapping.Map.PLAYERANDBOMB2){
					g2d.drawImage(playerandbomb2, i*32, j*32, 32, 32,this);	
				} else if(mapping.Map.board[j][i] == mapping.Map.EXPLOSION){
					g2d.drawImage(explosion, i*32, j*32, 32, 32,this);
				}
			}
			
		}
		
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
	try {
		dw.run();
	} catch (IOException e) {
		e.printStackTrace();
		drawing.Popup.popupMessage("Files not found. Have you downloaded the graphics?");
	}
	}
}
