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
	
	// JPanels are serializable, but we don't care here
    private static final long serialVersionUID = 1L;
    
    // Implement this interface to provide your own custom shape
	public interface CustomShape {
		public void paintComponent(Graphics g, int x, int y);		
	}
	
	// Default shape implementations
	static class OvalSprite implements CustomShape {
		@Override
		public void paintComponent(Graphics g, int x, int y) {
			g.setColor(Color.BLUE);
			g.drawOval((x-5)*2, (y-5)*2, 20, 20); 	
		}		
	}	
	static class RectSprite implements CustomShape {
		@Override
		public void paintComponent(Graphics g, int x, int y) {
			g.setColor(Color.RED);
			g.drawRect((x-5)*2, (y-5)*2, 20, 20);			
		}		
	}
	static class XSprite implements CustomShape {
		@Override
		public void paintComponent(Graphics g, int x, int y) {
			g.setColor(Color.GREEN);
			g.drawLine((x-5)*2, (y-5)*2, (x+5)*2, (y+5)*2);
		    g.drawLine((x+5)*2, (y-5)*2, (x-5)*2, (y+5)*2);			
		}		
	}
	static class FillOvalSprite implements CustomShape {
		@Override
		public void paintComponent(Graphics g, int x, int y) {
			g.setColor(Color.CYAN);
			g.fillOval((x-5)*2, (y-5)*2, 10*2, 10*2);
		}		
	}	
	static class FillRectSprite implements CustomShape {
		@Override
		public void paintComponent(Graphics g, int x, int y) {
			g.setColor(Color.PINK);
			g.fillRect((x-5)*2, (y-5)*2, 10*2, 10*2);	
		}		
	}
	        
    // Data structure for each sprite ... (x, y) coordinate and color
    private static class Sprite {
        int x;
        int y;
        CustomShape shape;
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
        for(Sprite s : sprites.values()) {
        	s.shape.paintComponent(g, s.x, s.y);
        }        
    }    
    
    // Create a new panel and a sweeper thread to go with it
    public SpritePanel() {
        (new Thread(new Sweeper())).start();        
    }
    
    // Assign a custom shape to this thread
    public synchronized void createSprite(CustomShape shape) {
    	Sprite sp = new Sprite();
    	sp.shape = shape;
    	sprites.put(Thread.currentThread(), sp);
    }
    
    // Pick a default shape if the user doesn't provide one
    int shapeCursor = -1;    
    private CustomShape getNextDefaultShape() {
    	++shapeCursor;
    	switch(shapeCursor % 5) {
    	case 0:
    		return new OvalSprite();
    	case 1:
    		return new RectSprite();
    	case 2:
    		return new XSprite();
    	case 3:
    		return new FillOvalSprite();
    	case 4:
    		return new FillRectSprite();
    		default:
    			return null;
    	}    	
    }
    
    // Threads call this to move their sprite on the screen. The first time a thread calls
    // this update it is assigned an avatar.
    public synchronized void updateMySprite(int x, int y) {
        Sprite sp = sprites.get(Thread.currentThread());
        if(sp==null) {
            // This is a new one ... track a new avatar
            sp = new Sprite();       
            sp.shape = getNextDefaultShape();            
            sprites.put(Thread.currentThread(), sp);
        }
        sp.x = x;
        sp.y = y;
        this.repaint();
    }
    
    // The constructor could do this automatically. But this way the SpritePanel
    // could be added to other panels or frames or applets.
    public void putPanelInAFrame() {
        // Adds THIS panel to a JFrame on the screen
        JFrame frame = new JFrame("Sprites");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        // The coordinate system is (0,0) - (99,99)
        this.setPreferredSize(new Dimension(100*2,100*2));
        frame.setContentPane(this);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);        
    }        

}
