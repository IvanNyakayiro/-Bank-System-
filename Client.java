/* Name: IVAN NYAKAYIRO 
* Course & Section: CST8132 304 
* Assignment: Lab03
* Date: September 28, 2018
*/

public class Client {
	private String firstName;
	private String lastName;
	private long phoneNum;
	private String email;

	Client(String firstName, String lastName, long phoneNum, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNum = phoneNum;
		this.email = email;

	}

	public String getName() {
		return (firstName + "," + lastName);
	}

	public long getPhoneNum() {
		return phoneNum;
	}

	public String getEmail() {
		return email;
	}

}
