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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
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
    private static Person getPersonWithEmail(String email) throws MongoException, Exception,IOException {
        try {
//            MongoClient abc = new MongoClient();
//            MongoDatabase db=abc.getDatabase("SEB");
            MongoCollection<?> collection = UtilityFunctions.getDataBase("SEB").getCollection("USERS");
            Document myDoc = (Document) collection.find(eq("emailID", email)).first();
            if(myDoc==null) {
                throw new Exception("Failed to locate user.");
            }
            Person user = new Person();
            ObjectMapper mapper = new ObjectMapper();
            myDoc.remove("_id");
            user = mapper.readValue(myDoc.toJson(),Person.class);
            return user;
        }
        catch(com.mongodb.MongoSocketOpenException|com.mongodb.MongoTimeoutException e)
        {
            throw new MongoException("DBNotAvailable");
        }catch (IOException e) {
            throw new IOException("CorruptedData");
        }
    }
    private static Person getPersonWithPhoneNumber(String phoneNumber) throws Exception{
        try {
//            MongoClient abc = new MongoClient();
//            MongoDatabase db=abc.getDatabase("SEB");
            MongoCollection<?> collection = UtilityFunctions.getDataBase("SEB").getCollection("USERS");
            Document myDoc = (Document) collection.find(eq("phoneNumber", phoneNumber)).first();
            if(myDoc==null) {
                throw new Exception("Failed to locate user.");
            }
            Person user = new Person();
            ObjectMapper mapper = new ObjectMapper();
            myDoc.remove("_id");
            user = mapper.readValue(myDoc.toJson(),Person.class);
            return user;
        }
        catch(com.mongodb.MongoSocketOpenException|com.mongodb.MongoTimeoutException e)
        {
            throw new MongoException("DBNotAvailable");
        }catch (IOException e) {
            throw new IOException("CorruptedData");
        }
    }
    private static Person getPersonWithCustomerID(String customerID) throws Exception{
        try {
//            MongoClient abc = new MongoClient();
//            MongoDatabase db=abc.getDatabase("SEB");
            MongoCollection<?> collection = UtilityFunctions.getDataBase("SEB").getCollection("USERS");
            Document myDoc = (Document) collection.find(eq("connection.meterNumber", customerID)).first();
            if(myDoc==null) {
                throw new Exception("Failed to locate user.");
            }
            Person user = new Person();
            ObjectMapper mapper = new ObjectMapper();
            myDoc.remove("_id");
            user = mapper.readValue(myDoc.toJson(),Person.class);
            return user;
        }
        catch(com.mongodb.MongoSocketOpenException|com.mongodb.MongoTimeoutException e)
        {
            throw new MongoException("DBNotAvailable");
        }catch (IOException e) {
            throw new IOException("CorruptedData");
        }
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username =findViewById(R.id.username);
        pass = findViewById(R.id.password);
        but = findViewById(R.id.sign_in_button);
        Person person = new Person();

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
                if(UtilityFunctions.isEmpty(ussrnm)){
                    String pas = new String(pass.getText().toString());
                    Toast.makeText(LoginActivity.this, "Please Enter username", Toast.LENGTH_SHORT).show();
                }
                if(UtilityFunctions.isEmpty(paswd)){
                    String pas = new String(pass.getText().toString());
                    Toast.makeText(LoginActivity.this, "Please Enter Password", Toast.LENGTH_SHORT).show();
                }
                try {
                    if (UtilityFunctions.isPhoneNumber(ussrnm)) {
                        String usrname = new String(username.getText().toString());
                        String pas = new String(pass.getText().toString());
                        Toast.makeText(LoginActivity.this, "Login via phn", Toast.LENGTH_SHORT).show();
                        person = getPersonWithPhoneNumber(ussrnm);
                    } else if (UtilityFunctions.isValidEmailAddress(ussrnm)) {
                        Toast.makeText(LoginActivity.this, "Is Valid Email", Toast.LENGTH_SHORT).show();

                        String email = new String(username.getText().toString());  // Use here email
                        String pas = new String(pass.getText().toString());
                        Toast.makeText(LoginActivity.this, "Login via email", Toast.LENGTH_SHORT).show();
                        person = getPersonWithEmail(ussrnm);
                        if(person != null){
                            Toast.makeText(LoginActivity.this, "Person retrieved from DB" + person.getEmailID(), Toast.LENGTH_SHORT).show();

                        }
                    } else if (UtilityFunctions.isValidMeterNumber(ussrnm)) {
                        String mtrnmbr = new String(username.getText().toString());  //Use here Customer Id
                        String pas = new String(pass.getText().toString());
                        Toast.makeText(LoginActivity.this, "Login via meter Number", Toast.LENGTH_SHORT).show();
                        person = getPersonWithCustomerID(ussrnm);
                    }
                }catch (Exception e){
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                }
                try
                {
                    person = objectMapper.readValue(dbResultJSON, Person.class);
                }
                catch (Exception e)
                {
                    person =null;
                }
                
                if(person.getPassword().equals(pass)){
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent main=new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(main);
                }
                else {
                    Toast.makeText(LoginActivity.this, "Password Validation Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}