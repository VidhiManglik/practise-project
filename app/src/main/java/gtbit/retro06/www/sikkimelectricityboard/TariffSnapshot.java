package gtbit.retro06.www.sikkimelectricityboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
}
