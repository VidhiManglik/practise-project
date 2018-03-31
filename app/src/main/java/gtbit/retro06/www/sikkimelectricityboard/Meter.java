package gtbit.retro06.www.sikkimelectricityboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;

public class Meter {
	String meterNumber;
	float capacityKW;
	Reading reading;
	Bill[] bills;

	public String getMeterNumber() {
		return meterNumber;
	}
	public Reading getReadings() {
		return reading;
	}
	public Bill[] getBills() {
		return bills;
	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
	}
	public float getCapacityKW() {
		return capacityKW;
	}
	public void setBills(Bill[] bills) {
		this.bills = bills;
	}
	public void setCapacityKW(float capacityKW) {
		this.capacityKW = capacityKW;
	}
	public void setMeterNumber(String meterNumber) {
		this.meterNumber = meterNumber;
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
	public static Meter parseJSON(String JSON) throws ParseException {
		JSONObject abc = ((org.json.simple.JSONObject)(new JSONParser()).parse(JSON));
		Meter meter = new Meter();
		try{
			meter.setMeterNumber((String)abc.get("meterNumber"));}
		catch (Exception e ) {
		}
		try{
			meter.setCapacityKW((float) abc.get("capacityKW"));}
		catch (Exception e ) {
		}
		try{
			meter.setReading(Reading.parseJSON((String)abc.get("reading")));}
		catch (Exception e ) {
		}
//		try{
//			List<Bill> abcd = new ArrayList<Bill>();
//			for()
//			meter.setBills((String)abc.get("bills"));}
//		catch (Exception e ) {
//		}
		return meter;
	}
}
