package drawing;

public class drawBlock {

	public void drawTextures(){
		
	}
	// Just nu är detta kod från DrawWindow som nog inte
	// ska läggas i DrawMap, utan något annat.
	
	// Blit image and flip...
	DrawWindow.dw.graphics = buffer.getDrawGraphics();
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
