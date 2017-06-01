
public class CirclePath implements Runnable {
    
    SpritePanel sp;

    @Override
    public void run() {      
        
        double r = 25.0;
        
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
