
/* Name: IVAN NYAKAYIRO 
* Course & Section: CST8132 304 
* Assignment: Lab03
* Date: September 28, 2018
*/
import java.util.Random;

public class Account {
	private long accountNum = new Random().nextLong();
	private Client client;
	private double balance;

	public Account(Client client, double balance) {
		this.client = client;
		this.balance = balance;
	}

	public String getName() {
		return client.getName();
	}

	public void deposit(double amt) {
		balance += amt;

	}

	public boolean withdraw(double amt) {
		boolean verify = false;
		if (amt < balance) {
			balance -= amt;
			verify = true;
		}
		return verify;
	}

	public long getAccountNum() {
		return accountNum;

	}

	public Client getClient() {
		return client;

	}

	public double getBalance() {
		return balance;
	}

}
