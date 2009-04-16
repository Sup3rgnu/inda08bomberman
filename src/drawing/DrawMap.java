package drawing;

import java.awt.*;	
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

	// Includes many various classes

import javax.imageio.ImageIO;



public class DrawMap {
	
	Canvas canvas; // Our drawing component
	
	
	public DrawMap(){
		
	}
	public void run() throws IOException {
		  
	    canvas.createBufferStrategy( 2 );
	    BufferStrategy buffer = canvas.getBufferStrategy();
	    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
	    GraphicsDevice gd = ge.getDefaultScreenDevice();
	    GraphicsConfiguration gc = gd.getDefaultConfiguration();
	    BufferedImage bi = gc.createCompatibleImage( DrawWindow.WIDTH, DrawWindow.HEIGHT );
	    
	    
	    Color background = Color.PINK;
	    
	    
	      try {
	      
	        // Clear the back buffer          
	        DrawWindow.dw.g2d = bi.createGraphics();
	        DrawWindow.dw.g2d.setColor( background );
	        DrawWindow.dw.g2d.fillRect( 0, 0, DrawWindow.WIDTH, DrawWindow.HEIGHT );
	        
	               
	        DrawWindow.dw.g2d.drawString( "--------------------------", 250, 200 );
	        DrawWindow.dw.g2d.drawString( "New Game", 250, 210 );
	        DrawWindow.dw.g2d.drawString( "Bomberman.exe", 250, 220 );
	        DrawWindow.dw.g2d.drawString( "Press Q to disconnect", 250, 230 );
	        DrawWindow.dw.g2d.drawString( "--------------------------", 250, 240 );

	        // Cajs tester
	        //Image test = Toolkit.getDefaultToolkit().getImage("bombe/bombe0.gif");
	         
	        Image crate = ImageIO.read(new File("graphics/crate.gif"));
	        Image stone = ImageIO.read(new File("graphics/stone.gif"));
	        Image grass = ImageIO.read(new File("graphics/grass.gif"));
	        Image player1 = ImageIO.read(new File("graphics/player1.gif"));
	        Image player2 = ImageIO.read(new File("graphics/player2.gif"));
	        		
	        //Graphics2D.drawImage(crate, i*32, j*32, 32, 32,(ImageObserver) this);
		        	
			for(int i=0; i <mapping.Map.HEIGHT; i++){
				for(int j=0; j < mapping.Map.WIDTH; j++){
					if(mapping.Map.board[i][j] == mapping.Map.UNBREAKABLE){
						DrawWindow.dw.g2d.drawImage(crate, i*32, j*32, 32, 32,(ImageObserver) this);
					}
					else if(mapping.Map.board[i][j] == mapping.Map.FREE){
						DrawWindow.dw.g2d.drawImage(grass, i*32, j*32, 32, 32,(ImageObserver) this);
					}
					else if(mapping.Map.board[i][j] == mapping.Map.PLAYER1){
						DrawWindow.dw.g2d.drawImage(player1, i*32, j*32, 32, 32,(ImageObserver) this);
					}
					else if(mapping.Map.board[i][j] == mapping.Map.PLAYER2){
						DrawWindow.dw.g2d.drawImage(player2, i*32, j*32, 32, 32,(ImageObserver) this);
					}
					
				}
				System.out.println();
			}
			//g2d.drawImage(crate, 0, 0, 32, 32,this);
	        
	      }finally{
	    	  
	      }
	   
	      
	      	
	}
	public static void DrawMapmain() throws IOException {
		DrawMap dm = new DrawMap();
		dm.run();
	  	}
}
