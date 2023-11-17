import client_lib.Client;
import client_lib.Credit;

public class test {
  public static void main(String[] args) {
    System.out.println("Class Tests:");

    /*// обработка массива строк
    System.out.println("String array processing: ");
    String[] strArr = new String[5];
    
    String str = "a";
    for(int i = 0; i < 5; i++){
    	strArr[i] = str;
    	str = str + str;
    	System.out.println(strArr[i]);
    }
    
    for(int i = 0; i < 5; i++){
    	strArr[i] = strArr[i] + "B";
    	System.out.println(strArr[i]);
    }*/
    
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

    System.out.println("\n" + (++test) + ") Test AddDeposit");
    cli.addNewDeposit(10, 1.08, 100000);
    cli.Deposits.get(0).toString();

    System.out.println("\n" + (++test) + ") Test addNewCredit");
    cli.addNewCredit(10, 1.08, 100000, 14902.95);
    cli.Credits.get(0).toString();
    
    System.out.println("\n" + (++test) + ") Exception handling test");
    cli.addNewCredit(10, 1.08, 100000, 7000);

    System.out.println("\n" + (++test) + ") Test ShowAllTransactionsInConsole");
    cli.Accounts.get(0).showAllTransactionInConsole();

    System.out.println("\n" + (++test) + ") Test GetFinalContributionsPayments");
    System.out.println("Final contrib pay: " + cli.Credits.get(0).getFinalContributionsPayments());

    System.out.println("\n" + (++test) + ") Test GetFinalDepositAmount");
    System.out.println("Final deposit amount: " + cli.Deposits.get(0).getFinalDepositAmount());

    System.out.println("\n" + (++test) + ") Test dynamic");
    Client cli_d = cli;
    cli_d.toString();
    cli_d.Accounts.get(0).makeTransaction(cli.Accounts.get(1), 100);
    cli_d.addNewCredit(5, 1.05, 10000, 1000);
    
    // работа с одномерным массивом объектов
    System.out.println("\n" + (++test) + ") One-dimensional array test");
    Client[] mass1_cli = new Client[3];
    for (int i = 0; i < 3; i++) 
    	mass1_cli[i] = new Client();
    mass1_cli[0].setName("Svjatoslav");
	mass1_cli[1].setName("Tihomir");
	mass1_cli[2].setName("Dobrinja");
	for (int i = 0; i < 3; i++) 
		System.out.println(mass1_cli[i].getName());
	
	// работа с двумерным массивом объектов
    System.out.println("\n" + (++test) + ") Two-dimensional array test");
    Client[][] mass2_cli = new Client[2][2];
    for(int i=0;i<2;i++)
		for (int j = 0; j < 2; j++) {
			mass2_cli[i][j] = new Client();
			mass2_cli[i][j].setName("Client[" + Integer.toString(i) + "][" + Integer.toString(j) + "]");
			System.out.println(mass2_cli[i][j].getName());
		}

    System.out.println("\n" + (++test) + ") Test InputClientFromConsole");
    Client cli_c = new Client();
    cli_c.inputClientFromConsole();
    cli_c.toString();

    System.out.println("\n" + (++test) + ") Test InputNewAccountFromConsole");
    cli_c.inputNewAccountFromConsole();
    cli_c.Accounts.get(0).toString();

    System.out.println("\n" + (++test) + ") Test InputNewCreditFromConsole");
    cli_c.inputNewCreditFromConsole();
    cli_c.Credits.get(0).toString();

    System.out.println("\n" + (++test) + ") Test InputNewDepositFromConsole");
    cli_c.inputNewDepositFromConsole();
    cli_c.Deposits.get(0).toString();

    System.out.println("\n" + (++test) + ") Test InputNewTransactionFromConsole");
    cli_c.Accounts.get(0).inputNewTransactionFromConsole(cli.Accounts.get(0));
    cli_c.Accounts.get(0).showAllTransactionInConsole();
  }
}