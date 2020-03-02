import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Point {
    
    private static Logger log = LogManager.getLogger("com.widget.graphics.Point");
    
    public void setX(int value) {
        log.debug("Setting X to "+value);
    }

}

