package gtbit.retro06.www.sikkimelectricityboard;

public class Person {
	String name;
	String phoneNumber;
	String role;
	String emailID;
	String customerAccountNumber;
	Connection connection;
	Bill[] previousBills;
	String password;
	Meter meter;
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
	public String getEmailID() {
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
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	public Bill[] getPreviousBills() {
		return previousBills;
	}
	public void setPreviousBills(Bill[] previousBills) {
		this.previousBills = previousBills;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Meter getMeter() {
		return meter;
	}
	public void setMeter(Meter meter) {
		this.meter = meter;
	}
	
	public void generateNewBill(){
		
	}
	
}
