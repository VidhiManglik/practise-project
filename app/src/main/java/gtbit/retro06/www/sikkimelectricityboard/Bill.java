package gtbit.retro06.www.sikkimelectricityboard;
import android.support.v7.app.AppCompatActivity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import android.os.Bundle;

public class Bill extends AppCompatActivity {
	final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	final long PAYMENT_GRACE_PERIOD = 10*24*60*60; // 10 days grace Period
	long billDate;
	long dueDate;
	long paymentDate; 
	long paymentAmount; 
	String paymentMethod;
	String status;
	Person customer;
	float amount;
	float unitsConsumed;
	// ServiceCenter billingCenter;
	Grid grid;
	Meter meter ;
	TariffSnapshot tariff;
	
	public long getDueDate() {
		return dueDate;
	}
	public long getPaymentDate() {
		return paymentDate;
	}
	public long getPaymentAmount() {
		return paymentAmount;
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
	public Person getCustomer() {
		return customer;
	}
	private void setCustomer(Person customer) {
		this.customer = customer;
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
	public Meter getMeter() {
		return meter;
	}
	private void setMeter(Meter meter) {
		this.meter = meter;
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
		this.paymentAmount = paymentAmount;
	}
	private void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	private void setStatus(String status) {
		this.status = status;
	}
	public Bill(long billDate, Person customer, float unitsConsumed, Grid grid, Meter meter, TariffSnapshot tariff) {
		this.setBillDate(billDate);
		this.setDueDate(billDate + PAYMENT_GRACE_PERIOD);
		this.setCustomer(customer);
		this.setUnitsConsumed(unitsConsumed);
		this.setGrid(grid);
		this.setMeter(meter);
		this.setTariff(tariff);
	}
	/*(int) (System.currentTimeMillis() / 1000L);*/
	public float calculateBillWithTariff(TariffSnapshot tariff){
		return tariff.calculateAmount(unitsConsumed);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_circulars_notices);
	}
}
