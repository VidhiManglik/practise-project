package gtbit.retro06.www.sikkimelectricityboard;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Person {
	String name;
	String phoneNumber;
	String role;
	String emailID;
	Meter connection;
	String password;

	public Person(){
		super();
	}

	public Person(String name, String phoneNumber, String emailID, String customerAccountNumber, Meter connection, String password) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.role = "CUSTOMER";
		this.emailID = emailID;
		this.customerAccountNumber = customerAccountNumber;
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

	public void generateNewBill() {
		//TODO:implement this method
	}

	public static Person parseJSON(String JSON) throws ParseException {
		JSONObject abc = ((org.json.simple.JSONObject)(new JSONParser()).parse(JSON));
		Person perso = new Person();
		try{
		perso.setName((String)abc.get("name"));}
		catch (Exception e ) {
		}
		try{
		perso.setPhoneNumber((String) abc.get("phoneNumber"));}
		catch (Exception e ) {
		}
		try{
		perso.setConnection(Meter.parseJSON((String)abc.get("connection")));}
		catch (Exception e ) {
		}
		try{
			perso.setPassword((String)abc.get("password"));}
		catch (Exception e ) {
		}
		try{
			perso.setEmailID((String)abc.get("emailID"));}
		catch (Exception e ) {
		}
		try{
			perso.setRole((String)abc.get("role"));}
		catch (Exception e ) {
		}
	return perso;
	}
}
