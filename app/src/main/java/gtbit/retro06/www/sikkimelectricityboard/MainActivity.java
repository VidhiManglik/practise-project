package gtbit.retro06.www.sikkimelectricityboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    public ImageButton button1,button2,button3,button4,button5,button6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1=findViewById(R.id.circular);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cir=new Intent(MainActivity.this,CircularsNotices.class);
                startActivity(cir);
            }
        });

        button2=findViewById(R.id.billhistory);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent billh=new Intent(MainActivity.this,Bill.class);
                startActivity(billh);
            }
        });

        button3=findViewById(R.id.billpayment);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent billp=new Intent(MainActivity.this,Payment.class);
                startActivity(billp);
            }
        });

        button4=findViewById(R.id.query);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent que=new Intent(MainActivity.this,UserQuery.class);
                startActivity(que);
            }
        });

        button5=findViewById(R.id.safetytips);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tips=new Intent(MainActivity.this,SafetyTips.class);
                startActivity(tips);
            }
        });

        button6=findViewById(R.id.nearbycenter);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent nbc=new Intent(MainActivity.this,NearByCenter.class);
                startActivity(nbc);
            }
        });
    }
}
