//package gtbit.retro06.www.sikkimelectricityboard;
//
//import android.os.AsyncTask;
//import android.util.Log;
//
//import org.json.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import java.io.DataOutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import static android.content.ContentValues.TAG;
//
///**
// * Created by tannu on 31/3/18.
// */
//
//class abc extends AsyncTask<String,Void,String> {
//
//    private Exception exception;
//
//    protected String doInBackground(String... urls) {
//     return getPOSTResponse(urls[0],urls[1]);
//    }
//
//    public static String getPOSTResponse(String URLInput, String requestData){
//        Log.e(TAG, "getValues: 13"+requestData,null );
//        String returnData = null;
//        try {
//            URL url = new URL(URLInput);
//            Log.e(TAG, "gues: 16"+requestData,null );
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            Log.e(TAG, "gues: 17"+requestData,null );
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
//            conn.setRequestProperty("Accept","application/json");
//            conn.setDoOutput(true);
//            conn.setDoInput(true);
//            // Log.i("JSON",);
//            DataOutputStream os = new DataOutputStream(conn.getOutputStream());
//            //os.writeBytes(URLEncoder.encode(jsonParam.toString(), "UTF-8"));
//            Log.e(TAG, "getVs: 21"+requestData,null );
//            os.writeBytes(requestData);
//            Log.e(TAG, "getVs: 18"+requestData,null );
//
//            os.flush();
//            Log.e(TAG, "getes: 19"+requestData,null );
//            os.close();
//            Log.e(TAG, "getValues: 14"+requestData,null );
//
//            Log.i("STATUS", String.valueOf(conn.getResponseCode()));
//            String JSONResponse = conn.getResponseMessage();
//            JSONParser parser = new JSONParser();
//            JSONObject bufferJSONObject = null;
//            bufferJSONObject = (JSONObject) parser.parse(JSONResponse);
//            returnData = bufferJSONObject.get("responseData").toString();
//            Log.e(TAG, "getValues: 15"+requestData,null );
//            conn.disconnect();
//        } catch (Exception e) {
////            conn
//            Log.e(TAG, "getValues: 20"+requestData,null );
//            e.printStackTrace();
//            Log.d("Failed to  CONNECT","NET problem"+e.toString());
//        }
//        return returnData;
//    }
//    protected void onPostExecute(String feed) {
//        return feed;
//    }
//}
