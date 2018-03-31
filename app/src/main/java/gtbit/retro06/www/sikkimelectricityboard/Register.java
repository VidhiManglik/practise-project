package gtbit.retro06.www.sikkimelectricityboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText rName,rEmail,rCANumber,rAddress,rPassword;
    private Button rButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        rName=findViewById(R.id.cname);
        rEmail=findViewById(R.id.email);
        rCANumber=findViewById(R.id.ca_num);
        rAddress=findViewById(R.id.addrs);
        rPassword=findViewById(R.id.password);
        rButton=findViewById(R.id.register_button);
        rButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Register.this, "qwerty", Toast.LENGTH_SHORT).show();
            }
        });


        //For Person class
        Person person = new Person();
        //person = objectMapper.readValue(dbResultJSON, Person.class);

    String name = rName.getText().toString();
    String email = rName.getText().toString();
    String canumber = rCANumber.getText().toString();
    String address = rAddress.getText().toString();
    String password = rPassword.getText().toString();


    }
}
