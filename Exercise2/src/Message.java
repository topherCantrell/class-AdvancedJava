import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
        
    private static final long serialVersionUID = 1L;
    
    String sender;
    Date posted;
    String message;
    
    public Message(String sender, String message) {
        posted = new Date();
        this.sender = sender;
        this.message = message;
    }
    
    @Override
    public String toString() {
        return "From "+sender+" @ "+posted+" : "+message;
    }
    
}
