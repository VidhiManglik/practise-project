package gtbit.retro06.www.sikkimelectricityboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fasterxml.jackson.core.JsonParser;

import org.json.JSONObject;

import java.text.ParseException;

public class TariffSnapshot extends AppCompatActivity {
	float lowSlabRate;
	float mediumSlabRate;
	float highSlabRate;
	int lowSlabLimit;
	int mediumSlabLimit;
	int highSlabLimit;

	public float calculateAmount(float unitsConsumed){
		float totalAmount = 0;
		unitsConsumed = Math.abs(unitsConsumed);
		if(unitsConsumed > 0 && unitsConsumed < lowSlabLimit){
			float lowSlabUsage = 0;
			if (unitsConsumed > lowSlabLimit){
				lowSlabUsage = lowSlabLimit;
				unitsConsumed -= lowSlabLimit;
			}
			else{
				lowSlabUsage = unitsConsumed;
				unitsConsumed = 0;

			}
			totalAmount += lowSlabUsage * lowSlabRate;
		}
		if(unitsConsumed > 0 && unitsConsumed < mediumSlabLimit){
			float SlabUsage = 0;
			if (unitsConsumed > mediumSlabLimit){
				SlabUsage = mediumSlabLimit;
				unitsConsumed -= mediumSlabLimit;
			}
			else{
				SlabUsage = unitsConsumed;
				unitsConsumed = 0;

			}
			totalAmount += SlabUsage * mediumSlabRate;
		}
		if(unitsConsumed > 0){
			totalAmount += unitsConsumed * highSlabRate;
		}

		return totalAmount;
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill);
    }


	public float getLowSlabRate() {
		return lowSlabRate;
	}

	public float getMediumSlabRate() {
		return mediumSlabRate;
	}

	public void setMediumSlabRate(float mediumSlabRate) {
		this.mediumSlabRate = mediumSlabRate;
	}

	public float getHighSlabRate() {
		return highSlabRate;
	}

	public int getLowSlabLimit() {
		return lowSlabLimit;
	}

	public void setLowSlabLimit(int lowSlabLimit) {
		this.lowSlabLimit = lowSlabLimit;
	}

	public int getMediumSlabLimit() {
		return mediumSlabLimit;
	}

	public void setMediumSlabLimit(int mediumSlabLimit) {
		this.mediumSlabLimit = mediumSlabLimit;
	}

	public int getHighSlabLimit() {
		return highSlabLimit;
	}

	public void setHighSlabLimit(int highSlabLimit) {
		this.highSlabLimit = highSlabLimit;
	}

	public static TariffSnapshot parseJSON(String JSON) throws ParseException{
		JSONObject abc = ((org.json.simple.JSONObject)(new JSONParser()).parse(JSON));
		TariffSnapshot tariff1 = new TariffSnapshot();
		try{tariff1.setLowSlabRate((float)abc.get("lowSlabRate"));}catch ( Exception e){}
		try{tariff1.setMediumSlabRate((float)abc.get("mediumSlabRate"));}catch ( Exception e){}
		try{tariff1.setHighSlabRate((float)abc.get("highSlabRate"));}catch ( Exception e){}
		try{tariff1.setLowSlabLimit((int)abc.get("lowSlabLimit"));}catch ( Exception e){}
		try{tariff1.setMediumSlabLimit((int)abc.get("mediumSlabLimit"));}catch ( Exception e){}
		try{tariff1.setHighSlabLimit((int)abc.get("highSlabLimit"));}catch ( Exception e){}
		return tariff1;
	}

	private void setHighSlabRate(float highSlabRate) {
	}

	private void setLowSlabRate(float lowSlabRate) {
	}
}
