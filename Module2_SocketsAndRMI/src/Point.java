import java.io.Serializable;

public class Point implements Serializable {       
    
    private static final long serialVersionUID = 0xDEAD_FEED;
    
    public int x;
    public int y;
    public int color;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public String toString() {
        return "("+x+","+y+"):"+color;
    }

}
