package client_lib;

import java.util.ArrayList;

public class Account {
  private int nextUniqueID = 0;
  private int ID;
  private double balance;
  private Client client;
  private ArrayList<Transaction> Transactions;

  public Account(Client client) {
    balance = 0;
    ID = nextUniqueID;
    nextUniqueID++;
    this.client = client;
    Transactions = new ArrayList<Transaction>();
  }

  public Account(double balance, Client client) {
    this.balance = balance;
    ID = nextUniqueID;
    nextUniqueID++;
    this.client = client;
    Transactions = new ArrayList<Transaction>();
  }

  public int getID() {
    return ID;
  }

  public double getBalance() {
    return balance;
  }

  public String getClientName() {
    return this.client.getName();
  }

  public void makeTransaction(Account alterAccount, double transactionMoney) {
    balance -= transactionMoney;
    alterAccount.setBalance(alterAccount.getBalance() + transactionMoney);

    Transaction newTransactionForMyAccount = new Transaction(alterAccount.getClientName(), alterAccount.getID(), transactionMoney, true);
    Transaction newTransactionForCounterAccount = new Transaction(alterAccount.getClientName(), getID(), transactionMoney, false);

    addNewTransaction(newTransactionForMyAccount);
    alterAccount.addNewTransaction(newTransactionForCounterAccount);
  }

  public void inputNewTransactionFromConsole(Account alterAccount) {
    String message = "Enter the amount you wish to transfer from " + getClientName() +
  " account number " + String.valueOf(getID()) + " to " + alterAccount.getClientName() +
  " account number " + String.valueOf(alterAccount.getID()) + ": ";

double transactionMoney;
boolean flag;

do {
  flag = false;
  transactionMoney = Input.inputDouble(message);
  if (transactionMoney == 0) {
    System.out.println("The transfer amount cannot be zero");
    flag = true;
  }
  if (transactionMoney > balance) {
    System.out.println("Insufficient funds in the account");
    flag = true;
  }
} while (flag);

makeTransaction(alterAccount, transactionMoney);
System.out.println("Operation was successfully completed");
  }

  
  @Override
  public String toString(){
	  String info = "Client: " + getClientName() + " num: " + String.valueOf(getID()) +
			  " balance: " + String.valueOf(getBalance());
	  return info;
  }

  public void showAllTransactionInConsole() {
    System.out.println("All transaction:");
    for (Transaction transaction : Transactions)
      transaction.toString();
  }

  public ArrayList<Transaction> getAllTransactions(){
    return this.Transactions;
  }

  private void setBalance(double newBalance) {
    balance = newBalance;
  }

  private void addNewTransaction(Transaction newTransaction) {
    Transactions.add(newTransaction);
  }
}