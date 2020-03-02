
public class LinePath implements Runnable {
    
    private SpritePanel sp;
    
    private int startX;
    private int startY;
    private int length;
    private int delay;
    private int offsetX;
    private int offsetY;
    
    public LinePath(SpritePanel sp, int startX, int startY, int length,
            int delay, int offsetX, int offsetY) 
    {
        this.sp = sp;
        this.startX = startX;
        this.startY = startY;
        this.length = length;
        this.delay = delay;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
    }

    @Override
    public void run() {
        
        int x=startX;
        int y=startY;
        
        while(true) {
            for(int c=0;c<length;++c) {
                sp.updateMySprite(x, y);
                x=x+offsetX;
                y=y+offsetY;
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            for(int c=0;c<length;++c) {
                sp.updateMySprite(x, y);
                x=x-offsetX;
                y=y-offsetY;
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
    }

}
