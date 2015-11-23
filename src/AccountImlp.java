import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by joshuapro on 2015-11-23.
 */
public class AccountImlp  extends UnicastRemoteObject implements Account{

    private float mBalance=0;
    private String mName="";

public AccountImlp(String name) throws RemoteException{
    mName=name;
}


    @Override
    public String getName() throws RemoteException {
        return mName;
    }

    @Override
    public float getBalance() throws RemoteException {
        return mBalance;
    }

    @Override
    public void withdraw(float amt) throws RemoteException {
mBalance -= amt;
        // make sure balance never drops below zero
        mBalance=Math.max(mBalance,0);
    }

    @Override
    public void deposit(float amt) throws RemoteException {
mBalance +=amt;

    }

    @Override
    public void transfer(float amt, Account scr) throws RemoteException {
        scr.withdraw(amt);
        mBalance +=amt;
    }

    @Override
    public void transfer(List a, List srcs) throws RemoteException {
        ListIterator amtCurs= a.listIterator();
        ListIterator srcCurs= srcs.listIterator();

        while(amtCurs.hasNext()&& srcCurs.hasNext()){
            Float amt=(Float)amtCurs.next();
            Account src=(Account)srcCurs.next();
            this.transfer(amt.floatValue(),src);
        }
    }
}
