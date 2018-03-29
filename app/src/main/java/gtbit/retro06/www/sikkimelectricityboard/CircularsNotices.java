package gtbit.retro06.www.sikkimelectricityboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CircularsNotices extends AppCompatActivity {
	String issueDate;
	ServiceCenter issuingCenter;
	String notificationContent;
	boolean serviceDisruptionOccurs;
	boolean localizedImpact;
	Grid gridAffected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulars_notices);
    }
}
