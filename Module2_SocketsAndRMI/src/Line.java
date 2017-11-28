import java.io.Serializable;

public class Line implements Serializable {    
    
    private static final long serialVersionUID = 1L;
    
    public Point a;
    public Point b;
    
    public Line(Point a, Point b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public String toString() {
        return "["+a+"-"+b+"]";
    }

}
