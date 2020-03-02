import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CorkBoard extends Remote {
    
    public void postMessage(Message message) throws RemoteException;
    
    public List<Message> getMessages() throws RemoteException;
    
    public void clearBoard() throws RemoteException;

}
