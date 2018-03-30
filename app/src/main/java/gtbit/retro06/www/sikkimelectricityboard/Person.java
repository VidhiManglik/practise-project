package gtbit.retro06.www.sikkimelectricityboard;

public class Person {
	String name;
	String phoneNumber;
	String role;
	String emailID;
	String customerAccountNumber;
	Meter connection;
	String password;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmailID()  {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getCustomerAccountNumber() {
		return customerAccountNumber;
	}
	public void setCustomerAccountNumber(String customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}
	public Meter getConnection() {
		return connection;
	}
	public void setConnection(Meter connection) {
		this.connection = connection;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void generateNewBill(){
		//TODO:implement this method
	}
	
	
}
