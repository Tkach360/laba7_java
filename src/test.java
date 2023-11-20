import client_lib.Client;
import client_lib.Credit;
import client_lib.IAccount;
import client_lib.Deposit;

public class test {
  public static void main(String[] args) {
    System.out.println("Class Tests:");
    
    int test = 0;

    Client cli = new Client("Igor", 23, "234234");
    System.out.println("\n" + (++test) + ") Test constructor with all parameters");
    cli.toString();

    System.out.println("\n" + (++test) + ") Test AddAccount");
    cli.addNewAccount(10000);
    cli.Accounts.get(0).toString();

    cli.addNewAccount(10000);
    System.out.println("\n" + (++test) + ") Test MakeTransaction");
    cli.Accounts.get(0).makeTransaction(cli.Accounts.get(1), 5000);
    cli.Accounts.get(0).showAllTransactionInConsole();
    cli.Accounts.get(1).showAllTransactionInConsole();

    System.out.println("\n" + (++test) + ") Test AddNewDeposit");
    cli.addNewDeposit(10, 1.08, 100000);
    System.out.println(cli.Deposits.get(0).toString());

    System.out.println("\n" + (++test) + ") Test addNewCredit");
    cli.addNewCredit(10, 1.08, 100000, 14902.95);
    System.out.println(cli.Credits.get(0).toString());
    
    System.out.println("\n" + (++test) + ") Test interface");
    IAccount iacc = cli.Accounts.get(0);
    System.out.println(iacc.toString());
    
    System.out.println("\n" + (++test) + ") Test surface cloning");
    Deposit clone = cli.Deposits.get(0);
    System.out.println(clone.toString());
    
    System.out.println("\n" + (++test) + ") Test deep cloning");
    Deposit dclone = cli.Deposits.get(0).clone();
    System.out.println(dclone.toString());
  }
}