package gtbit.retro06.www.sikkimelectricityboard;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by tannu on 30/3/18.
 */

public class UtilityFunctions {
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
    public static boolean isValidCustomerId(String id){
        Pattern p = Pattern.compile("[A-Za-z0-9]+");
        Matcher m = p.matcher(id);

        if (m.find())
            return true;
        return false;
    }

}
