import client_lib.Client;
import client_lib.Credit;
import client_lib.IAccount;
import client_lib.Deposit;

public class test {
  public static void main(String[] args) {
	  System.out.println("Class Tests:");

	  int test = 0;

	  Client cli = new Client("Igor", 23, "234234");
	  System.out.println("\n" + ++test + ") Test sortedAccountsByBalance"); //1
	  for (int i = 5; i > 0; i--)
	    cli.addNewAccount(i * 1000);

	  System.out.println("Before sorted:");
	  for (int i = 0; i < cli.Accounts.size(); i++)
	    System.out.println(cli.Accounts.get(i));

	  cli.sortedAccountsByBalance();

	  System.out.println("After sorted:");
	  for (int i = 0; i < cli.Accounts.size(); i++){
	    System.out.println(cli.Accounts.get(i));
	  }

	  System.out.println("\n" + ++test + ") Test getAccountByID"); //2
	  System.out.println(cli.getAccountByID(1).toString());
  }
}