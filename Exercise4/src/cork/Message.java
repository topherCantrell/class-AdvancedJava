package cork;
import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
        
    private static final long serialVersionUID = 1L;
    
    private String sender;
    private Date posted;
    private String message;
    
    public Message(String sender, String message) {
        posted = new Date();
        this.sender = sender;
        this.message = message;
    }
        
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public Date getPosted() {
        return posted;
    }
    public void setPosted(Date posted) {
        this.posted = posted;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "From "+sender+" @ "+posted+" : "+message;
    }
    
}
