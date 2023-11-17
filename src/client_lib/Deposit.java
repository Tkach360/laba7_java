package client_lib;

import client_lib.BankService;

public class Deposit extends BankService implements Cloneable {
  public Deposit() {
    super();
  }
  public Deposit(int Years) {
    super(Years);
  }
  public Deposit(double Body) {
    super(Body);
  }
  public Deposit(int Years, double Percent, double Body) {
    super(Years, Percent, Body);
  }
  
  @Override
  public Deposit clone(){
	  try {
          return (Deposit) super.clone();
      } catch (CloneNotSupportedException e) {
          e.printStackTrace();
          return null;
      }
  }
  
  public double getFinalDepositAmount() {
    double finalDepositAmount = getBody();
    int years = getYears();
    for (int i = 0; i < years; i++) {
      finalDepositAmount *= getPercent();
    }
    return finalDepositAmount;
  }
  
  @Override
  public String toString(){
	  String info = "Deposit year: " + Integer.toString(this.getYears()) + " body: " + Double.toString(this.getBody()) +
		      " percent: " + Double.toString(this.getPercent());
	  return info;
  }
}