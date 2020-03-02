import java.awt.Color;
import java.awt.Graphics;

// Just FYI ... this is how you make a custom shape
class BullsEye implements SpritePanel.CustomShape {
	@Override
	public void paintComponent(Graphics g, int x, int y) {
		g.setColor(Color.BLACK);
		g.drawOval(x-10, y-10, 20, 20);
		g.drawOval(x-6,  y-6,  12, 12);
		g.drawOval(x-2,  y-2,  4,  4);				
	}	
}

public class CirclePath implements Runnable {
    
    SpritePanel sp;

    @Override
    public void run() {      
        
        double r = 25.0;
        
        // Use a custom shape.
        sp.createSprite(new BullsEye());
        
        while(true) {
            for(double angle=0; angle<=2*Math.PI; angle=angle+Math.PI/36.0) {
                
                double x = r * Math.cos(angle);
                double y = r * Math.sin(angle);
                
                sp.updateMySprite((int)(x+50), (int)(y+50));
                
                try {
                    synchronized(this) {
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }            
                
            }
        }
        
        
    }

}
