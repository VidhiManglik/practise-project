package gtbit.retro06.www.sikkimelectricityboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Bill{
	final static DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	public static DateFormat getDateFormat() {
		DATE_FORMAT.setTimeZone(java.util.TimeZone.getTimeZone("GMT+5.30"));
		return DATE_FORMAT;
	}
	final long PAYMENT_GRACE_PERIOD = 10*24*60*60; // 10 days grace Period in seconds
	long billDate;
	String billNumber;
	long dueDate;
	long paymentDate; 
	long paidAmount; 
	String paymentMethod;
	String status;
	float amount;
	float unitsConsumed;
	Grid grid;
	TariffSnapshot tariff;
	public String getBillNumber(){return billNumber;}
	public void setBillNumber(String billNumber){ this.billNumber=billNumber;}
	public long getDueDate() {
		return dueDate;
	}
	public long getPaymentDate() {
		return paymentDate;
	}
	public long getPaymentAmount() {
		return paidAmount;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public String getStatus() {
		return status;
	}
	public boolean isBillOverDue(){
		if ((int) (System.currentTimeMillis() / 1000L) > dueDate)
			return true;
		else
			return false;
	}
	public long getBillDate() {
		return billDate;
	}
	private void setBillDate(long billDate) {
		this.billDate = billDate;
	}
	public float getAmount() {
		return amount;
	}
	private void setAmount(float amount) {
		this.amount = amount;
	}
	public float getUnitsConsumed() {
		return unitsConsumed;
	}
	private void setUnitsConsumed(float unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
		if(this.getTariff() != null)
			this.setAmount(tariff.calculateAmount(this.unitsConsumed));
	}
	public Grid getGrid() {
		return grid;
	}
	private void setGrid(Grid grid) {
		this.grid = grid;
	}
	public TariffSnapshot getTariff() {
		return tariff;
	}
	private void setTariff(TariffSnapshot tariff) {
		this.tariff = tariff;
		if (this.unitsConsumed != 0)
			this.setAmount(tariff.calculateAmount(unitsConsumed));
	}
	private void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}
	private void setPaymentDate(long paymentDate) {
		this.paymentDate = paymentDate;
	}
	private void setPaymentAmount(long paymentAmount) {
		this.paidAmount = paymentAmount;
	}
	private void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	private void setStatus(String status) {
		//permitted values are "PAID","DUE","OVERDUE","LAPSE"
		this.status = status;
	}
	public Bill(long billDate, float unitsConsumed, Grid grid, TariffSnapshot tariff) {
		this.setBillDate(billDate);
		this.setDueDate(billDate + PAYMENT_GRACE_PERIOD);
		this.setUnitsConsumed(unitsConsumed);
		this.setGrid(grid);
		this.setTariff(tariff);
	}
	public Bill(){
		super();
	}
	/*(int) (System.currentTimeMillis() / 1000L);*/
	public float calculateBillWithTariff(TariffSnapshot tariff){
		return tariff.calculateAmount(unitsConsumed);
	}
	public String getBillDateString(){
		Date dateObject = new Date(billDate*1000);
		return Bill.getDateFormat().format(dateObject);
	}
	public void setBillDateFromString(String date)throws ParseException{
		Date dateObject=Bill.getDateFormat().parse(date);
		this.billDate = dateObject.getTime()%1000;
	}
	public String getPaymentDateString(){
		Date dateObject = new Date(paymentDate*1000);
		return Bill.getDateFormat().format(dateObject);
	}
	public void setPaymentDateFromString(String date)throws ParseException{
		Date dateObject=Bill.getDateFormat().parse(date);
		this.paymentDate = dateObject.getTime()%1000;
	}
	public String getDueDateString(){
		Date dateObject = new Date(dueDate*1000);
		return Bill.getDateFormat().format(dateObject);
	}
	public void setDueDateFromString(String date)throws ParseException{
		Date dateObject=Bill.getDateFormat().parse(date);
		this.dueDate = dateObject.getTime()%1000;
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_bill);
	}
}
