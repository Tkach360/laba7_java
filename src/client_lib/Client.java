package client_lib;

import java.util.ArrayList;
import java.util.List;

public class Client { 
	
    private int age;
    private String name;
    private String phoneNumber;
    
    // использование блока инициализации исключения throw
    private void checkNewCredit(int years, double percent, double body, double contrib){
    	if(!Credit.isVerifyCredit(years, body, percent, contrib))
    		throw new IllegalArgumentException("Incorrect credit details.");
    }

    public ArrayList<Credit> Credits;
    public ArrayList<Deposit> Deposits;
    public ArrayList<Account> Accounts;

    public Client() {
        this.name = "NONE";
        this.age = -1;
        this.phoneNumber = "NONE";
        this.Credits = new ArrayList<Credit>();
        this.Deposits = new ArrayList<Deposit>();
        this.Accounts = new ArrayList<Account>();
    }

    public Client(String name) {
        this.name = name;
        this.age = -1;
        this.phoneNumber = "NONE";
        this.Credits = new ArrayList<Credit>();
        this.Deposits = new ArrayList<Deposit>();
        this.Accounts = new ArrayList<Account>();
    }

    public Client(int age) {
        this.age = age;
        this.name = "NONE";
        this.phoneNumber = "NONE";
        this.Credits = new ArrayList<Credit>();
        this.Deposits = new ArrayList<Deposit>();
        this.Accounts = new ArrayList<Account>();
    }

    public Client(String name, int age, String phoneNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.Credits = new ArrayList<Credit>();
        this.Deposits = new ArrayList<Deposit>();
        this.Accounts = new ArrayList<Account>();
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int getAge() {
        return this.age;
    }

    public Account getAccountByID(int ID) {
        return Accounts.get(ID);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void inputClientFromConsole() {
        this.name = Input.inputClientName("Enter the name of the new client (First name Last name): ");
        this.age = Input.inputInt("Enter the age of the new client: ");
        this.phoneNumber = Input.inputClientPhoneNumber("Enter the phone number of the new client (X-XXX-XXX-XX-XX): ");

        System.out.println("Client successfully registered");
    }

    // разумное использование оператора this
    public void addNewAccount(double money) {
        Account newAccount = new Account(money, this);
        this.Accounts.add(newAccount);
    }

    public void inputNewAccountFromConsole() {
        double money = Input.inputDouble("Enter the initial amount in the account: ");

        addNewAccount(money);
        System.out.println("Account created successfully");
    }

    public void addNewCredit(int years, double percent, double body, double contrib) {
    	try{
    		checkNewCredit(years, percent, body, contrib);
    		Credit newCredit = new Credit(years, percent, body, contrib);
    		this.Credits.add(newCredit);
    	}
    	catch(IllegalArgumentException e){
    		System.out.println(e.getMessage());
    	}
    }

    public void addNewCredit(Credit newCredit) {
    	try{
    		checkNewCredit(newCredit.getYears(), newCredit.getPercent(), newCredit.getBody(), newCredit.getContrib());
    		this.Credits.add(newCredit);
    	}
    	catch(IllegalArgumentException e){
    		System.out.println(e.getMessage());
    	}
    }

    public void inputNewCreditFromConsole() {
        Credit newCredit = new Credit();
        
        // возврат целочисленного значения через вспомогательный класс
        newCredit.setYear(Input.inputInt("Enter the number of years for which you want to take out a loan: "));
        newCredit.setBody(Input.inputDouble("Enter the loan amount: "));
        do {
            newCredit.setPercent(Input.inputDouble("Enter the loan interest (1.XX..): "));
            if (newCredit.getPercent() < 1) System.out.println("percentage cannot be less than 1");
        } while (newCredit.getPercent() < 1);
        newCredit.setContrib(Input.inputDouble("Enter the monthly payment amount: "));

        addNewCredit(newCredit);
        System.out.println("Loan taken successfully");
    }

    public void addNewDeposit(int Year, double Percent, double Body) {
        Deposit newDeposit = new Deposit(Year, Percent, Body);
        this.Deposits.add(newDeposit);
    }

    public void addNewDeposit(Deposit newDeposit) {
        this.Deposits.add(newDeposit);
    }

    public void inputNewDepositFromConsole() {
        Deposit newDeposit = new Deposit();
        newDeposit.setYear(Input.inputInt("Enter the number of years for which you want to open a deposit: "));
        newDeposit.setBody(Input.inputDouble("Enter the deposit amount: "));
        do {
            newDeposit.setPercent(Input.inputDouble("Enter the interest accrued per year on the deposit (1.XX..): "));
            if (newDeposit.getPercent() < 1) System.out.println("percentage cannot be less than 1");
        } while (newDeposit.getPercent() < 1);

        addNewDeposit(newDeposit);
        System.out.println("Money has been successfully deposited");
    }

    public double getAllAccountsMoney() {
        double allAccountsMoney = 0;
        for (Account account : Accounts) {
            allAccountsMoney += account.getBalance();
        }
        return allAccountsMoney;
    }

    public ArrayList<Transaction> getAllTransactions() {
        ArrayList<Transaction> allTransactions = new ArrayList<Transaction>();
        for (Account account : Accounts) {
            allTransactions.addAll(account.getAllTransactions());
        }
        return allTransactions;
    }

    public void showInConsole() {
        System.out.println("Name: " + this.name + " Age: " + this.age + " Phone number: " +
            this.phoneNumber);
        System.out.println("  Accounts: " + this.Accounts.size() + " Credits: " +
            this.Credits.size() + " Deposits: " + this.Deposits.size());
    }

    public ArrayList<Account> getAllAccounts() {
        return this.Accounts;
    }

    public ArrayList<Deposit> getAllDeposits() {
        return this.Deposits;
    }

    public ArrayList<Credit> getAllCredits() {
        return this.Credits;
    }
}