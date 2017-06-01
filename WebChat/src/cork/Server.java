package cork;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {

    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        CorkBoardImpl cb = new CorkBoardImpl();
        CorkBoard stub = (CorkBoard) UnicastRemoteObject.exportObject(cb, 0);
        
        Registry registry = LocateRegistry.getRegistry();
        registry.bind("CorkBoard",  stub);        

    }

}
