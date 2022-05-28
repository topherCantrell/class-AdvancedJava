import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class SpritePanel extends JPanel {
    
    // Scaling factor
    private static final int SF = 2;
    
    // JPanels are serializable, but we don't care here
    private static final long serialVersionUID = 1L;
    
    // Avatar colors
    private static final Color [] COLORS = {
            Color.BLUE,
            Color.RED,
            Color.GREEN,
            Color.CYAN,
            Color.PINK,
            Color.YELLOW,
            Color.GRAY,
            Color.MAGENTA,
    };
    
    // Color for the next avatar created (increments and rolls)
    private int colorCursor;
    
    // Data structure for each sprite ... (x, y) coordinate and color
    private static class Sprite {
        int x;
        int y;
        Color color;
    }    
    
    // Collections of sprites ... mapped to the using thread
    private Map<Thread,Sprite> sprites = new HashMap<Thread,Sprite>();
    
    // This thread checks for threads that have died and removes the
    // associated avatar from the screen.
    private class Sweeper implements Runnable {
        @Override
        public void run() {
            while(true) {
                sweepThreads();
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }            
        }        
    }
    
    private synchronized void sweepThreads() {
        boolean changed = false;
        Iterator<Entry<Thread, Sprite>> ents = sprites.entrySet().iterator();
        while(ents.hasNext()) {
            Entry<Thread, Sprite> ent = ents.next();
            if(!ent.getKey().isAlive()) {
                ents.remove();
                changed = true;
            }
        }        
        if(changed) {
            this.repaint();
        }
    }
    
    @Override
    protected synchronized void paintComponent(Graphics g) {
        super.paintComponent(g);
        int pos = 0;
        for(Sprite s : sprites.values()) {
            g.setColor(s.color);            
            switch(pos%5) {
            case 0:
                g.drawOval((s.x-5)*SF, (s.y-5)*SF, 10*SF, 10*SF);                
                break;
            case 1:
                g.drawRect((s.x-5)*SF, (s.y-5)*SF, 10*SF, 10*SF);
                break;
            case 2:
                g.drawLine((s.x-5)*SF, (s.y-5)*SF, (s.x+5)*SF, (s.y+5)*SF);
                g.drawLine((s.x+5)*SF, (s.y-5)*SF, (s.x-5)*SF, (s.y+5)*SF);
                break;
            case 3:
                g.fillOval((s.x-5)*SF, (s.y-5)*SF, 10*SF, 10*SF);
                break;
            case 4:                
                g.fillRect((s.x-5)*SF, (s.y-5)*SF, 10*SF, 10*SF);
                break;
            } 
            pos++;
        }
    }       
    
    
    // Create a new panel and a sweeper thread to go with it
    public SpritePanel() {
        (new Thread(new Sweeper())).start();        
    }
    
    // Threads call this to move their sprite on the screen. The first time a thread calls
    // this update it is assigned an avatar.
    public synchronized void updateMySprite(int x, int y) {
        Sprite sp = sprites.get(Thread.currentThread());
        if(sp==null) {
            // This is a new one ... track a new avatar
            sp = new Sprite();            
            sp.color = COLORS[colorCursor];
            colorCursor++;
            if(colorCursor>=COLORS.length) {
                colorCursor = 0;
            }
            sprites.put(Thread.currentThread(), sp);
        }
        sp.x = x;
        sp.y = y;
        this.repaint();
    }
    
    public synchronized Color getMyColor() {
        // In case you want to know what color you are
        Sprite sp = sprites.get(Thread.currentThread());
        if(sp==null) return null;
        return sp.color;
    }
    
    public void putPanelInAFrame() {
        // Adds THIS panel to a JFrame on the screen
        JFrame frame = new JFrame("Sprites");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        // The coordinate system is (0,0) - (99,99)
        this.setPreferredSize(new Dimension(100*SF,100*SF));
        frame.setContentPane(this);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);        
    }        

}
