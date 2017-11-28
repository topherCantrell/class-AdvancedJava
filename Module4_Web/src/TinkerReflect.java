import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
  

public class TinkerReflect {
        
    public static void main(String[] args) throws Exception { 
        
        Class<?> tinkerClass = TinkerReflect.class;
        Class<?> cc = tinkerClass.getClassLoader().loadClass("Point");
                
        Object ob = cc.newInstance();
                
        Field fx = cc.getDeclaredField("x");        
        Field fy = cc.getDeclaredField("y");
                
        //fx.setAccessible(true);
        //fy.setAccessible(true);
               
        fx.setInt(ob, 100);
        fy.setInt(ob, 200);
                
        System.out.println(ob.toString());
        
    }  

}
