//package gtbit.retro06.www.sikkimelectricityboard;
//
//import android.util.Log;
//
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import java.io.DataOutputStream;
//import java.lang.reflect.Field;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class  Post {
//    public String getPOSTResponse(String URLInput, Object requestData){
//        try {
//            URL url = new URL(URLInput);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//            conn.setRequestProperty("Accept","application/json");
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            Log.i("JSON",toJSON(requestData));
//            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
//            //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
//            os.writeBytes(toJSON(requestData));
//            os.flush();
//            os.close();
//            Log.i("STATUS", String.valueOf(conn.getResponseCode()));
//            String JSONResponse = conn.getResponseMessage();
//            JSONParser parser = new JSONParser();
//            JSONObject bufferJSONObject = null;
//            bufferJSONObject = (JSONObject) parser.parse(JSONResponse);
//            String returnData = bufferJSONObject.get("responseData").toString();
//            conn.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d("Failed to  CONNECT","NET problem"+e.toString());
//        }
//    }
//    public String getPOSTResponse(String URLInput, String requestData){
//        try {
//            URL url = new URL(URLInput);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//            conn.setRequestProperty("Accept","application/json");
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            // Log.i("JSON",);
//            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
//            //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
//            os.writeBytes(requestData);
//
//            os.flush();
//            os.close();
//
//            Log.i("STATUS", String.valueOf(conn.getResponseCode()));
//            String JSONResponse = conn.getResponseMessage();
//            JSONParser parser = new JSONParser();
//            JSONObject bufferJSONObject = null;
//            bufferJSONObject = (JSONObject) parser.parse(JSONResponse);
//            String returnData = bufferJSONObject.get("responseData").toString();
//            conn.disconnect();
//        } catch (Exception e) {
//            e.printStackTrace();
//            Log.d("Failed to  CONNECT","NET problem"+e.toString());
//        }
//    }
//    public static String toJSON(Object object) throws JSONException, IllegalAccessException {
//        String str = "";
//        Class c = object.getClass();
//        JSONObject jsonObject = new JSONObject();
//        for (Field field : c.getDeclaredFields()) {
//            field.setAccessible(true);
//            String name = field.getName();
//            String value = String.valueOf(field.get(object));
//            jsonObject.put(name, value);
//        }
//        System.out.println(jsonObject.toString());
//        return jsonObject.toString();
//    }
//}
//        });
//}
