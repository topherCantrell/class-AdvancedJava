
public class SquarePath implements Runnable {
    
    SpritePanel sp;
    int x=5;
    int y=5;

    @Override
    public void run() {
        while(true) {
            
            try {
                moveOverLine(1,0);            
                moveOverLine(0,1);
                moveOverLine(-1,0);
                moveOverLine(0,-1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }
        
    }
    
    private void moveOverLine(int xOffset, int yOffset) throws InterruptedException {
        for(int c=0;c<100;++c) {
            sp.updateMySprite(x, y);
            x=x+xOffset;
            y=y+yOffset;
            Thread.sleep(10);            
        }
    }
    

}
