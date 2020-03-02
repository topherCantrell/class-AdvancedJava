package utils;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) throws Exception {
        
        Registry reg = LocateRegistry.getRegistry("localhost");
        
        StringUtil stub = (StringUtil) reg.lookup("StringUtil");
        
        String a = stub.append("Hello", "World");
        System.out.println(a);
        
        a = stub.allCaps("excited");
        System.out.println(a);       

    }

}
