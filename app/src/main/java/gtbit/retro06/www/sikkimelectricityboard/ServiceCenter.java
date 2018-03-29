package gtbit.retro06.www.sikkimelectricityboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ServiceCenter extends AppCompatActivity {
	String address;
	Person[] staff;
	Grid[] grid;
	String[] services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by_center);
    }
}
