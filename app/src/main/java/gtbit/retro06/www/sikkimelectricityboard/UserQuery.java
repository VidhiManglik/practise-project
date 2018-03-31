package gtbit.retro06.www.sikkimelectricityboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class UserQuery extends AppCompatActivity {

    private RecyclerView verticalList;
    private VerticalListAdapter verticalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_query);


            verticalList = (RecyclerView)findViewById(R.id.vertical_recycler);


            verticalList.setHasFixedSize(true);

            //set vertical LinearLayout as layout manager for vertial listview
            LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
            verticalList.setLayoutManager(layoutManager);
            verticalAdapter = new VerticalListAdapter(this);
            verticalList.setAdapter(verticalAdapter);
        }
    }