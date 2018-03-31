package gtbit.retro06.www.sikkimelectricityboard;

public class Person {
	String name;
	String phoneNumber;
	String role;
	String emailID;
	String customerAccountNumber;
	Meter connection;
	String password;

	public Person(){
		super();
	}

	public Person(String name, String phoneNumber, String emailID, Meter connection, String password) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.role = "CUSTOMER";
		this.emailID = emailID;
//		this.customerAccountNumber = customerAccountNumber;
		this.connection = connection;
		this.password = password;
	}

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
	public String toJSONString(){
		String output = "";
		output += "{\"name\":\""+this.name+"\",\"phoneNumber\":\""+this.getPhoneNumber()+
				"\",\"emailID\":\""+this.emailID+"\",\"connection\":"+this.connection.toJSONString()+
				",\"password\":\""+this.password+"\"}";
		return output;
	}
}
