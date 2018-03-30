package gtbit.retro06.www.sikkimelectricityboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AdminActivity extends AppCompatActivity {

    public Button button1,button2,button3,button4,button5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        /*button1 = findViewById(R.id.meterreading);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cir=new Intent(AdminActivity.this,MeterReadingUpdate.class);
                startActivity(cir);
            }
        });*/

        button2=findViewById(R.id.billhistory);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent billh=new Intent(AdminActivity.this,Bill.class);
                startActivity(billh);
            }
        });

        button3=findViewById(R.id.billpayment);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent billp=new Intent(AdminActivity.this,Payment.class);
                startActivity(billp);
            }
        });

        button4=findViewById(R.id.query);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent que=new Intent(AdminActivity.this,UserQuery.class);
                startActivity(que);
            }
        });

        button5=findViewById(R.id.safetytips);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tips=new Intent(AdminActivity.this,SafetyTips.class);
                startActivity(tips);
            }
        });
    }
}
