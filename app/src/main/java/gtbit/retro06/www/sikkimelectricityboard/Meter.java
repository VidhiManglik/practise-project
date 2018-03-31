package gtbit.retro06.www.sikkimelectricityboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Meter extends AppCompatActivity {
	String meterNumber;
	float capacityKW;
	Reading reading;
	Bill[] bills;

	public String getMeterNumber() {
		return meterNumber;
	}

	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}

	public float getCapacityKW() {
		return capacityKW;
	}

	public void setCapacityKW(float capacityKW) {
		this.capacityKW = capacityKW;
	}

	public Reading getReading() {
		return reading;
	}

	public void setReading(Reading reading) {
		this.reading = reading;
	}

	public Bill[] getBills() {
		return bills;
	}

	public void setBills(Bill[] bills) {
		this.bills = bills;
	}

	public Meter(){
		super();
	}

	public Meter(String meterNumber, float capacityKW, Reading readings, Bill[] bills) {
		this.meterNumber = meterNumber;
		this.capacityKW = capacityKW;
		this.reading = readings;
		this.bills = bills;
	}

	public Reading getReadingAt(String date){
		//TODO:generate implementation of this method.
		return null;
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
    }
	public String toJSONString(){
		String output = "";
		output += "{\"meterNumber\":\""+this.meterNumber+"\",\"capacityKW\":\""+this.getCapacityKW()+
				"\",\"reading\":\""+this.getReading()+"\",\"bills\":[";
		boolean first = true;
				for(Bill b : bills){
					if(!first)
						output += ","
					output += b.toJSONString() + ",";first = false;}
//				output
				output += "]"+ " \"reading\":"+this.reading.toJSONString()+"}";
		return output;
	}
}

