import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Point {
    int x,y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public String toString() {
        return "("+x+","+y+")";
    }
    public int getX() {return x;}
    public int getY() {return y;}
}

class ComparePointX implements Comparator<Point> {
    @Override
    public int compare(Point p, Point q) {
        return p.getX()-q.getX();
    }    
}

public class Tinker2 {    

    public static void main(String[] args) {
        
        List<Point> points = new ArrayList<Point>();
        points.add(new Point(10,5));
        points.add(new Point(-8,20));
        points.add(new Point(0,0));
        
        System.out.println(points);
        
        points.sort(new ComparePointX());
        points.sort((p,q) -> p.getX()-q.getX());
        
        System.out.println(points);

    }

}
