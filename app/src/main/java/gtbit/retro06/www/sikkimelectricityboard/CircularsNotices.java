package gtbit.retro06.www.sikkimelectricityboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class CircularsNotices extends AppCompatActivity {
	String issueDate;
	ServiceCenter issuingCenter;
	String notificationContent;
	boolean serviceDisruptionOccurs;
	boolean localizedImpact;
	Grid gridAffected;

	private RecyclerView horizontalList;
	private HorizontalListAdapter horizontalAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulars_notices);
		horizontalList = (RecyclerView)findViewById(R.id.horizontal_recycler);

		horizontalList.setHasFixedSize(true);

		//set horizontal LinearLayout as layout manager to creating horizontal list view

		LinearLayoutManager horizontalManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
		horizontalList.setLayoutManager(horizontalManager);
		horizontalAdapter = new HorizontalListAdapter(this);
		horizontalList.setAdapter(horizontalAdapter);

    }
}
