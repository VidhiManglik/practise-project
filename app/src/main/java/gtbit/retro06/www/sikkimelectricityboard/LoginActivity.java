package gtbit.retro06.www.sikkimelectricityboard;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import static android.Manifest.permission.READ_CONTACTS;
import static com.mongodb.client.model.Filters.eq;
import static java.lang.String.*;
public class LoginActivity extends AppCompatActivity
{
    private EditText username;
    private EditText pass;
    private Button but;

    @JsonIgnore
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username =findViewById(R.id.username);
        pass = findViewById(R.id.password);
        but = findViewById(R.id.sign_in_button);
        Person person = new Person();

        TextView logtoreg =(TextView)findViewById(R.id.logreg);
        logtoreg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent= new Intent(LoginActivity.this,Register.class);
                startActivity(regIntent);
            }
        });

//        person.setPhoneNumber(ussrnm);
//        person.setPassword(paswd);
        final ObjectMapper objectMapper = new ObjectMapper();
        but.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


                String paswd = new String(pass.getText().toString());
                String ussrnm = new String(username.getText().toString());
                String dbResultJSON = "";
                Person person = new Person();
                if (UtilityFunctions.isEmpty(ussrnm)) {
                    String pas = new String(pass.getText().toString());
                    Toast.makeText(LoginActivity.this, "Please Enter username", Toast.LENGTH_SHORT).show();
                }
                if (UtilityFunctions.isEmpty(paswd)) {
                    String pas = new String(pass.getText().toString());
                    Toast.makeText(LoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                try {
                    if (UtilityFunctions.isPhoneNumber(ussrnm)) {
                        String usrname = new String(username.getText().toString());
                        String pas = new String(pass.getText().toString());
                        Toast.makeText(LoginActivity.this, "Login via phn", Toast.LENGTH_SHORT).show();

                        JSONObject requestData = new JSONObject();
                        requestData.put("phoneNumber", username.getText().toString());
                        requestData.put("password", pas);
                        String p = (String) UtilityFunctions.getValues(UtilityFunctions.getLoginUrl(),requestData.toString(),"person" , Person.class);
                        if (p == null){
                            Toast.makeText(LoginActivity.this, "abcde", Toast.LENGTH_SHORT).show();
                        }
                        else{

                        }
                    } else if (UtilityFunctions.isValidEmailAddress(ussrnm)) {

                        Toast.makeText(LoginActivity.this, "Is Valid Email", Toast.LENGTH_SHORT).show();

                        String email = new String(username.getText().toString());  // Use here email
                        String pas = new String(pass.getText().toString());
                        Toast.makeText(LoginActivity.this, "Login via email", Toast.LENGTH_SHORT).show();

                        JSONObject requestData = new JSONObject();
                        requestData.put("emailID", username.getText().toString());
                        requestData.put("password", pas);
                        Person p = (Person) UtilityFunctions.getValues(UtilityFunctions.getLoginUrl(),requestData.toString(),"person" , Person.class);
                        Toast.makeText(LoginActivity.this, "Person being retrieved from DB" + person.getEmailID(), Toast.LENGTH_SHORT).show();
                        if (p != null) {
                            Toast.makeText(LoginActivity.this, "Person retrieved from DB" + person.getEmailID(), Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Login failed, try again later!", Toast.LENGTH_SHORT).show();
                        }
                    } else if (UtilityFunctions.isValidMeterNumber(ussrnm)) {
                        String mtrnmbr = new String(username.getText().toString());  //Use here Customer Id
                        String pas = new String(pass.getText().toString());
                        Toast.makeText(LoginActivity.this, "Login via meter Number", Toast.LENGTH_SHORT).show();

                        JSONObject requestData = new JSONObject();
                        requestData.put("connection.meterNumber", username.getText().toString());
                        requestData.put("password", pas);
                        Person p = (Person) UtilityFunctions.getValues(UtilityFunctions.getLoginUrl(),requestData.toString(),"person" , Person.class);
                    }
                } catch (Exception e) {
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
                try {
                    person = objectMapper.readValue(dbResultJSON, Person.class);
                } catch (Exception e) {
                    person = null;
                }

                if (person!= null) {
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                     Intent main = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(main);
                } else {
                    Toast.makeText(LoginActivity.this, "Password Validation Failed", Toast.LENGTH_SHORT).show();
                }
            }
            });
    }
}