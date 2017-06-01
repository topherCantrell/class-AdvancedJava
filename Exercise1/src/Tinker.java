
public class Tinker {       
        
    public static void main(String [] args) {
        
        // Create the sprite panel
        SpritePanel sp = new SpritePanel();
        
        // Put the panel on the screen
        sp.putPanelInAFrame();        
        
        LinePath lp1 = new LinePath(sp,10,10,75,50,1,0);
        LinePath lp2 = new LinePath(sp,75,75,75,25,-1,-1);  
        LinePath lp3 = new LinePath(sp,10,10,40,10,0,1);  
        
        Thread t1 = new Thread(lp1);
        t1.start();
        
        Thread t2 = new Thread(lp2);
        t2.start(); 
        
        Thread t3 = new Thread(lp3);
        t3.start();
        
        SquarePath sq = new SquarePath();
        sq.sp = sp;
        
        Thread t4 = new Thread(sq);
        t4.start();
        
        
        CirclePath p = new CirclePath();
        p.sp = sp;
        
        Thread t = new Thread(p);
        t.start();
        
        while(true) {
            
            synchronized(p) {
                p.notify();
            }
            
            try {
                Thread.sleep(25);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
    }

}
