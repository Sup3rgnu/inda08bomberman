package drawing;

public class drawBlock {

	public void drawTextures(){
		
	}
	// Just nu �r detta kod fr�n DrawWindow som nog inte
	// ska l�ggas i DrawMap, utan n�got annat.
	
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
