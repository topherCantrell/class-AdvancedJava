package cork;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class Client {
    
    static void printMessages(List<Message> messages) {
        for(Message m : messages) {
            System.out.println(" * "+m);
        }
    }
    
    static void makeDemoData(CorkBoard stub) throws RemoteException, NumberFormatException, InterruptedException {
        String [] demoData = {
                "John",   "Anybody working on class tonight?", "3000",
                "Jan",    "I will later - at the movies now.", "2000",
                "Reice",  "Cool! What are you seeing?", "5000",
                "Jan",    "Empire Strikes Back!", "4000",
                "John",   "Darth Vader is Luke's father!", "6000",
                "Reice",  "NOOOOO! SPOILER!", "1000",
        };
        int pos = 0;
        while(pos<demoData.length) {
            Message m = new Message(demoData[pos], demoData[pos+1]);
            stub.postMessage(m);
            Thread.sleep(Integer.parseInt(demoData[pos+2]));
            pos = pos + 3;
        }
    }

    public static void main(String[] args) throws Exception {
        
        Registry registry = LocateRegistry.getRegistry("localhost");        
        CorkBoard stub = (CorkBoard) registry.lookup("CorkBoard");
        
        if(args.length==0) {
            // TODO print help
        }
        
        switch(args[0]) {
        
        case "!":
            makeDemoData(stub);
            break;
        
        case "*":
            stub.clearBoard();
            // Falling through on purpose
        case "?":
            List<Message> ms = stub.getMessages();
            printMessages(ms);
            break;
        
            default:
                Message m = new Message(args[0],args[1]);
                stub.postMessage(m);                
                
        }      
        

    }

}
