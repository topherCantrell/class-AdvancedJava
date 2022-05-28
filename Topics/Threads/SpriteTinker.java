
public class SpriteTinker {       
        
    public static void main(String [] args) throws InterruptedException {
        
        // Create the sprite panel
        SpritePanel sp = new SpritePanel();
        
        // Put the panel on the screen
        sp.putPanelInAFrame();
        
        // The sprite panel will automatically create an avatar for every
        // thread that calls "updateMySprite". When a thread goes away
        // the panel will automatically remove the avatar. 
        
        // Move a sprite in a triangle pattern
        int x=25;
        int y=25;
        while(true) {
            // Diagonal
            for(int z=0;z<50;++z) {
                sp.updateMySprite(x, y);
                x=x+1;y=y+1;
                Thread.sleep(25);
            }
            // Left
            for(int z=0;z<50;++z) {
                sp.updateMySprite(x, y);
                x=x-1;
                Thread.sleep(5);
            }
            // Up
            for(int z=0;z<50;++z) {
                sp.updateMySprite(x, y);
                y=y-1;
                Thread.sleep(5);
            }
        }
        
    }

}
