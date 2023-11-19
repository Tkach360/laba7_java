package client_lib;

import java.util.Date;

public class Transaction<T, V> {
	private boolean sent;
	private double money;
	private String alterClientName;
	private V alterAccountID;
	private T time;

	Transaction(String alterClientName, V alterAccountID, double money, boolean sent) {
		this.sent = sent;
		this.alterAccountID = alterAccountID;
		this.alterClientName = alterClientName;
		this.money = money;
		time = (T) new Date();
	}

	public boolean getSent() {
		return this.sent;
	}
	public double getMoney() {
		return this.money;
	}
	public String getAlterClientName() {
		return this.alterClientName;
	}
	public V getAlterAccountID() {
		return alterAccountID;
	}
	public T getTime() {
		return time;
	}

	@Override
	public String toString(){
		String strTime = time.toString();
		String strMoney, strAlterClientName, strAlterAccountID;

		if (sent) {
			strMoney = "-" + Double.toString(money);
			strAlterClientName = "to " + alterClientName;
		}
		else {
			strMoney = "+" + Double.toString(money);
			strAlterClientName = "from " + alterClientName;
		}

		strAlterAccountID = String.valueOf(alterAccountID);
		return "Time: " + strTime + " " + strMoney + " " + strAlterClientName + " acc. " + strAlterAccountID;
	}
};