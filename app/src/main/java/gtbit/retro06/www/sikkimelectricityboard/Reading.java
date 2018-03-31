package gtbit.retro06.www.sikkimelectricityboard;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Reading {
	long date;
	float reading;

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public float getReading() {
		return reading;
	}

	public void setReading(float reading) {
		this.reading = reading;
	}

	public static Reading parseJSON(String JSON)throws ParseException{
		JSONObject abc = ((JSONObject)(new JSONParser()).parse(JSON));
		Reading read = new Reading();
		read.setDate((long)abc.get("date"));
		read.setReading((float) abc.get("reading"));
		return read;
	}
}
