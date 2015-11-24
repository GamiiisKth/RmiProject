import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by ali on 2015-11-24.
 */
public class server  {
private static final int PORT=5133;
private static Registry registry;

    public static void startRegistery() throws RemoteException{
        // creayte server registery

        registry = LocateRegistry.createRegistry(PORT);
    }
    public static void registerObject(String name,Remote remoteObj) throws RemoteException,AlreadyBoundException{

        // bind the object in the register
        // It is bind the with certain name
        // client will lookup on the the registertion of the name to get object

        registry.bind(name,remoteObj);
        System.out.println("Registerated with "+ name + "["+ remoteObj.getClass().getName() +"]" );
    }

    public static void main(String [] args) throws RemoteException, AlreadyBoundException {
        System.out.println("server starting...");
        startRegistery();
        registerObject(Account.class.getName(),new AccountImlp("Ali"));
        System.out.println("server started and listining to client...");

    }
}
