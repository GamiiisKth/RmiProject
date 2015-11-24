import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by joshuapro on 2015-11-24.
 */


// client
public class RegAccount  {
    private static final String Host="localhost";
    private static final int PORT=5133;
    private static Registry registry;

    public static void main(String [] args) throws RemoteException, NotBoundException {
      registry =LocateRegistry.getRegistry(Host,PORT);
        Account account= (Account)registry.lookup(Account.class.getName());
        account.deposit(12000);

        System.out.println("Balance " + account.getBalance() +" Name "+ account.getName());

    }
}
