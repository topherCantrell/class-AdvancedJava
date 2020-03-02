import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Tinker {

    public static void main(String[] args) {
        
        Logger a = LogManager.getLogger("sue");
        
        try {
            String s = null;
            s.length();
        } catch (Exception e) {
            a.error("Bad things happened",  e);
        }        

    }

}
