package gr.uom.thema2;

import android.os.StrictMode;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpHandler {

    public OkHttpHandler() {
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    ArrayList<Multi> populateDropDown(String url) throws Exception {
        ArrayList<Multi> aList = new ArrayList<>();

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url(url)  // Use the parameter here instead of "url"
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();


        String data = response.body().string();
        Log.d("OkHttpHandler", "Server response: " + data);
        System.out.println("My Response: " + data);
        try {
            JSONArray jsonArray = new JSONArray(data);
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject item = jsonArray.getJSONObject(i);

                String image1 = item.getString("image1");
                String image2 = item.getString("image2");
                String oper1 = item.getString("oper1");
                String oper2 = item.getString("oper2");
                String res = item.getString("res");

                aList.add(new Multi(image1, image2, oper1, oper2, res));
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
        // Επιστρέφουμε την λίστα
        return aList;
    }
}

