package gtbit.retro06.www.sikkimelectricityboard;

import android.support.annotation.Nullable;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by tannu on 30/3/18.
 */

public class UtilityFunctions {
    static MongoClient dbClient;
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
