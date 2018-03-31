package gtbit.retro06.www.sikkimelectricityboard;

import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import static android.content.ContentValues.TAG;
//
//import static gtbit.retro06.www.sikkimelectricityboard.Post.toJSON;

/**
 * Created by tannu on 30/3/18.
 */

public class UtilityFunctions {
    static MongoClient dbClient;
    private static final String SERVER_NAME = "http://192.168.43.122";
    private static final String SERVER_PORT = "8080";
    private static final String LOGIN_URL = "SEBDataAccessAPI/DataAPI/Login";
    private static final String BILLS_URL = "SEBDataAccessAPI/DataAPI/Bills";
    private static final String BILL_URL = "SEBDataAccessAPI/DataAPI/Bill";
    private static final String NEW_CONNECTION_URL = "SEBDataAccessAPI/DataAPI/NewConnection";
    private static final String NEW_COMPLAINT_URL = "SEBDataAccessAPI/DataAPI/NewComplaint";
    private static final String NEW_REGISTRATION_URL = "SEBDataAccessAPI/DataAPI/NewRegistration";
    private static final String GET_SERVICE_CENTERS = "SEBDataAccessAPI/DataAPI/getServiceCenters";
    public String getPOSTResponse(String URLInput, Object requestData){
        String returnData = null;
        try {
            URL url = new URL(URLInput);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Accept","application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            Log.i("JSON",toJSON(requestData));
            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
            //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
            os.writeBytes(toJSON(requestData));
            os.flush();
            os.close();
            Log.i("STATUS", String.valueOf(conn.getResponseCode()));
            String JSONResponse = conn.getResponseMessage();
            JSONParser parser = new JSONParser();
            JSONObject bufferJSONObject = null;
            bufferJSONObject = (JSONObject) parser.parse(JSONResponse);
            returnData = bufferJSONObject.get("responseData").toString();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("Failed to  CONNECT","NET problem"+e.toString());
        }
        return returnData;
    }

    public static String getPOSTResponse(String URLInput, String requestData){
        Log.e(TAG, "getValues: 13"+requestData,null );
        String returnData = null;
        try {
            URL url = new URL(URLInput);
            Log.e(TAG, "getValues: 16"+requestData,null );
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            Log.e(TAG, "getValues: 17"+requestData,null );
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("Accept","application/json");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // Log.i("JSON",);
            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
            //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
            Log.e(TAG, "getValues: 21"+requestData,null );
            os.writeBytes(requestData);
            Log.e(TAG, "getValues: 18"+requestData,null );

            os.flush();
            Log.e(TAG, "getValues: 19"+requestData,null );
            os.close();
            Log.e(TAG, "getValues: 14"+requestData,null );

            Log.i("STATUS", String.valueOf(conn.getResponseCode()));
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            //String output;
            String JSONResponse = "";
            System.out.println("Output from Server .... \n");
            String output;
            while ((output = br.readLine()) != null) {
                JSONResponse += output;
            }
//             JSONResponse= conn.getResponseMessage();
            Log.e(TAG, "getValues: 14 - response is"+JSONResponse,null );
            JSONParser parser = new JSONParser();
            JSONObject bufferJSONObject = (JSONObject) parser.parse(JSONResponse);
            Log.e(TAG, "getValues: 14.5 - response is"+JSONResponse,null );
            returnData = bufferJSONObject.get("responseData").toString();
            Log.e(TAG, "getValues: 15"+returnData,null );
            conn.disconnect();
        } catch (Exception e) {
            Log.e(TAG, "getValues: 20"+requestData,null );
            e.printStackTrace();
            Log.d("Failed to  CONNECT","NET problem"+e.toString());
        }
        return returnData;
    }

    public static String toJSON(Object object) throws JSONException, IllegalAccessException {
        String str = "";
        Class c = object.getClass();
        JSONObject jsonObject = new JSONObject();
        for (Field field : c.getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            String value = String.valueOf(field.get(object));
            jsonObject.put(name, value);
        }
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }
    public static String getLoginUrl() {
        return SERVER_NAME+":" + SERVER_PORT+"/"+LOGIN_URL;
    }

    public static String getBillsUrl() {
        return SERVER_NAME+":" + SERVER_PORT+"/"+BILLS_URL;
    }

    public static String getBillUrl() {
        return SERVER_NAME+":" + SERVER_PORT+"/"+BILL_URL;
    }

    public static String getNewConnectionUrl() {
        return SERVER_NAME+":" + SERVER_PORT+"/"+NEW_CONNECTION_URL;
    }

    public static String getNewComplaintUrl() {
        return SERVER_NAME+":" + SERVER_PORT+"/"+NEW_COMPLAINT_URL;
    }

    public static String getNewRegistrationUrl() {
        return SERVER_NAME+":" + SERVER_PORT+"/"+NEW_REGISTRATION_URL;
    }

    public static String getGetServiceCenters() {
        return SERVER_NAME+":" + SERVER_PORT+"/"+GET_SERVICE_CENTERS;
    }


    public static boolean isPhoneNumber(String phoneNumber) {
        PhoneNumberUtil phoneUtil = PhoneNumberUtil.getInstance();
        Phonenumber.PhoneNumber numberProto = null;
        try {
            numberProto = phoneUtil.parse(phoneNumber, "");
        } catch (NumberParseException e) {
            return false;
        }
        if(phoneUtil.isValidNumber(numberProto))
            return true;
        else
            return false;
    }

    public static Object getValues(String URL, String requestData , String key, Class ResponseDataClass) {
        Object o = null;
        String JSONResponse= null;
        Log.e(TAG, "getValues: 12"+requestData,null );
        try {
//            abc task = new abc();
            if (android.os.Build.VERSION.SDK_INT > 9) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
            }
            JSONResponse = UtilityFunctions.getPOSTResponse(URL, requestData);
            Log.e(TAG, "getValues: 12"+JSONResponse,null );
        } catch (Exception e) {
//            Toast.makeText(, "", Toast.LENGTH_SHORT).show();
        }
        JSONObject basicObject = null;
        try {
            Log.e(TAG, "getValues: 24.5"+JSONResponse,null );
            basicObject = (JSONObject)new JSONParser().parse(JSONResponse);
        } catch (ParseException e) {
            return null;
        }
        Log.e(TAG, "getValues: 25"+basicObject,null );
        ObjectMapper mapper = new ObjectMapper();
        try {
            o = ResponseDataClass.newInstance();
            Log.e(TAG, "getValues: 25.5"+basicObject.get(key).toString(),null );
            o = basicObject.get(key).toString();
//            o= mapper.readValue(, Person.class);
            Log.e(TAG, "getValues: 26",null );
        }
        catch (Exception e ){
            e.printStackTrace();
            Log.e(TAG, "getValues: 25.5"+e.getMessage(),null );
            o=null;
        }
        return o;
    }

    public static MongoClient getDBClient(){
        return new MongoClient("192.168.43.122",27017);
    }
    public static MongoDatabase getDataBase(String DBName){
        return getDBClient().getDatabase(DBName);
    }
    public static boolean isEmpty(@Nullable CharSequence str) {
        return str == null || str.length() == 0;
    }

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }
    public static boolean isValidMeterNumber(String id){
        if(id.length() > 7)
            return false;
        Pattern p = Pattern.compile("[A-Za-z0-9]+");
        Matcher m = p.matcher(id);

        if (m.find())
            return true;
        return false;
    }

}
