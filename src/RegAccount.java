import java.rmi.Naming;

/**
 * Created by joshuapro on 2015-11-24.
 */
public class RegAccount  {

    public static void main(String [] args){
        try {

            AccountImlp acct= new AccountImlp("JimF");
            Naming.rebind("JimF",acct);
            System.out.println("Registered account");
        }catch (Exception e){

            e.printStackTrace();

        }
    }
}
