package gtbit.retro06.www.sikkimelectricityboard;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import static android.Manifest.permission.READ_CONTACTS;
import static java.lang.String.*;
public class LoginActivity extends AppCompatActivity
{
    private EditText number;
    private EditText pass;
    private Button but;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        number =findViewById(R.id.phn);
        pass = findViewById(R.id.password);
        but = findViewById(R.id.phn_sign_in_button);
//        final String num1 = new String("9876543210");
//        final
        final ObjectMapper objectMapper = new ObjectMapper();
        but.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Person person = new Person();
                person.setPhoneNumber("8800768091");
                person.setPassword("qwertyuiop");
                String num = new String(number.getText().toString());
                String pas = new String(pass.getText().toString());
                String dbResultJSON = "";
                if(UtilityFunctions.isPhoneNumber(num)){
                    //Query to get person with phoneNumber
                }
                else if (UtilityFunctions.isValidEmailAddress(num)){
                    //Query to get person with EmailID
                }
                else if (UtilityFunctions.isValidCustomerId(num)){
                    //Query to get person with CustID
                }
                else{
                    //Throw error here. The id entered is invalid
                }
                try {
                    person = objectMapper.readValue(dbResultJSON, Person.class);
                }
                catch(Exception e ){
                    person = null;
                }
                if(person.getPassword().equals(pas)){
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Password Validation Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}