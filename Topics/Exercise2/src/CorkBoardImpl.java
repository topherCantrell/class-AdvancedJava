import java.util.ArrayList;
import java.util.List;

public class CorkBoardImpl implements CorkBoard {
    
    private List<Message> messages;
    
    public CorkBoardImpl() {
        messages = new ArrayList<Message>();
        Message startup = new Message("SYSTEM", "Started Server");
        messages.add(startup);
    }

    @Override
    public void postMessage(Message message) {
        messages.add(message);        
        System.out.println(message);
    }

    @Override
    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public void clearBoard() {
        messages.clear();
        Message cleared = new Message("SYSTEM", "Messages Cleared");
        messages.add(cleared);
    }

}
