package utils;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    
    public static void main(String [] args) throws Exception {
        
        StringUtilImpl obj = new StringUtilImpl();
        
        StringUtil skel = (StringUtil) UnicastRemoteObject.exportObject(obj,0);
        
        Registry reg = LocateRegistry.getRegistry();
        
        reg.bind("StringUtil", skel);
        
    }

}
