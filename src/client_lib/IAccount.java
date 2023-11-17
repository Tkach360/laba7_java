package client_lib;

import java.util.ArrayList;

public interface IAccount {
	  public int getID();

	  public double getBalance();

	  public String getClientName();

	  public void makeTransaction(Account alterAccount, double transactionMoney);

	  public void inputNewTransactionFromConsole(Account alterAccount);

	  @Override
	  public String toString();

	  public void showAllTransactionInConsole();

	  public ArrayList<Transaction> getAllTransactions();
}
