import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Tinker {
    
    @SuppressWarnings("unused")
    public static void main(String [] args) throws Exception {        
        
                
        Point a = new Point(0xFACE,0xBEEF);
        Point b = new Point(0,0);
        Point c = new Point(5,8);
        
        Line x = new Line(a,b);
        Line y = new Line(b,c);        
                
        OutputStream os = new FileOutputStream("test.bin");
        
        ObjectOutputStream oos = new ObjectOutputStream(os);
        
        oos.writeObject(x);
        oos.writeObject(y);
        
        oos.flush();
        oos.close();     
        
        
          
                
        InputStream is = new FileInputStream("test.bin");
        
        ObjectInputStream iis = new ObjectInputStream(is);
        
        Line t = (Line) iis.readObject();
        Line u = (Line) iis.readObject();
        
        iis.close();
        
        Point ta = t.a;
        Point tb = t.b;
        
        Point ua = u.a;
        Point ub = u.b;
        
        System.out.println(t);
        System.out.println(u);
        ua.x = -1;
        ua.y = -1;
        System.out.println(t);
        System.out.println(u);
        
        
        
    }

}
