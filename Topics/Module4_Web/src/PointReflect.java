import java.io.Serializable;

import org.junit.Test;

public class PointReflect implements Serializable {
        
    private static final long serialVersionUID = 1L;
    
    private int x;
    private int y;
    
    public PointReflect() {
        // Already 0
    }    
    
    public PointReflect(int x, int y) {        
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x) {this.x = x;}
    
    public void setY(int y) {this.y = y;} 
    
    public int getX() {return x;}
    
    public int getY() {return y;}
    
    @Test
    public void testPoint() {
        System.out.println("Testing");
    }
    
    public String toString() {
        return "("+x+","+y+")";
    }

}
