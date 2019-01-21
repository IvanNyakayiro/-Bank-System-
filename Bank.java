
/* Name: IVAN NYAKAYIRO 
* Course & Section: CST8132 304 
* Assignment: Lab03
* Date: September 28, 2018
*/
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.text.DecimalFormat;

public class Bank {
	private static Scanner input = new Scanner(System.in); // change to static so main method can access it
	private Account[] accounts;
	private String bankName;
	private int numAcc; 
	
	
	/** formats the output with a thousands separator */
	static DecimalFormat df = new DecimalFormat("###,###.###");
	private Client myClient;

	public Bank() {
		System.out.println("Bank Name? ");
		bankName = input.nextLine();
		System.out.println("Number of Accounts:");
		numAcc = input.nextInt(); // verify that the input is a valid integer value
		while (numAcc < 1) {
			System.out.println("Number of Accounts must be  1 or bigger :");
			numAcc = input.nextInt();
		}
		accounts = new Account[numAcc]; // array initialize

		for (int i = 0; i < accounts.length; i++) {
			System.out.println("Fisrt Name");
			String firstName = input.next();
			System.out.println("Last name");
			String lastName = input.next();
			System.out.println("phone number");
			long phoneNum = input.nextLong(); 
			System.out.println("Email address. ");
			String email = input.next();
			String regex3 = "\\b[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}\\b";
			Pattern pattern1 = Pattern.compile(regex3, Pattern.CASE_INSENSITIVE);
			Matcher match1 = pattern1.matcher(email);
			boolean valid = true;
			while (valid) {
				if (!match1.find()) {
					System.out.println("Invalid Email Eg: xxx@xxxx.xxm"); // validate email address
																			
					email = input.next();
					match1 = pattern1.matcher(email);
				} else {
					valid = false;
				}

			}
			myClient = new Client(firstName, lastName, phoneNum, email);
			System.out.println("Opening Balance:");
			double mybalance = input.nextDouble(); // BONUS MARK: verify that the input is a valid integer value
			accounts[i] = new Account(myClient, mybalance);
		}

	}

	public void printAccounts() {
		for (int i = 0; i < accounts.length; i++) {
			System.out.print("Bank Name: " + bankName);
			System.out.print(" Account Number: " + accounts[i].getAccountNum()); // NEED EXPLANATION ON WHY AND HOW?
			System.out.print(" Client Names: " + accounts[i].getName());
			System.out.print(" Phone Number: " + accounts[i].getClient().getPhoneNum());
			System.out.print(" Email: " + accounts[i].getClient().getEmail());
			System.out.print(" Balance: " + df.format(accounts[i].getBalance()));
			System.out.println();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user;
		int index;
		double amt;
		boolean exit=true;
		Bank obj = new Bank();
		System.out.println("WELCOME TO MY BANK SYSTEM");
		 do{
			System.out.print("P:printAccounts " + "\n" + "W:withdraw" + "\n" + "D:deposit" + "\n" + "Q: Quit.");
			user = input.next();// fix the loop!!!!!!!
			switch (user) {
			case "q":
			case "Q":
				exit = false;
				break;
			case "p":
			case "P":
				obj.printAccounts();
				break;
			case "w":
			case "W":
				System.out.println("What Account: ");
				index = input.nextInt();
				System.out.println("How much: ");
				amt = input.nextDouble();
				boolean verify = obj.accounts[index - 1].withdraw(amt);
				if (verify == false) {
					System.out.println(
							"Insufficient Funds! Balance is $" + df.format(obj.accounts[index - 1].getBalance()));
				}
				break;
			case "d":
			case "D":
				System.out.println("What Account: ");
				index = input.nextInt();
				System.out.println("How much: ");
				amt = input.nextDouble();
				obj.accounts[index - 1].deposit(amt);
				break;

			}
		}while (exit);
	}

}
