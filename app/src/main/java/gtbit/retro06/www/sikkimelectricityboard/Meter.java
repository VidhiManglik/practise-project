package gtbit.retro06.www.sikkimelectricityboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Meter extends AppCompatActivity {
	String meterNumber;
	float capacityKW;
	Reading[] readings;
	Bill[] bills;

	public Reading getReadingAt(String date){
		//TODO:generate implementation of this method.
		return null;
	}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
    }
}
