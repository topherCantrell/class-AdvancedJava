package utils;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface StringUtil extends Remote {
    
    public String append(String a, String b) throws RemoteException;
    
    public String allCaps(String s) throws RemoteException;

}
