import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Created by joshuapro on 2015-11-23.
 */

// remote Account interface
public interface Account extends Remote {

    public String getName()throws RemoteException;
    public float getBalance() throws RemoteException;
    public void withdraw(float amt) throws RemoteException;
    public void deposit(float amt) throws RemoteException;
    public void transfer(float amt, Account scr ) throws RemoteException;
    public void transfer(List a, List srcs) throws RemoteException;

}
