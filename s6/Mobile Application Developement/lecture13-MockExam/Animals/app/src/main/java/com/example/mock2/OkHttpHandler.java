package com.example.mock2;

import android.os.StrictMode;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.*;

public class OkHttpHandler {

    public OkHttpHandler() {
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    ArrayList<Animal> populateDropDown(String url) throws Exception {
        ArrayList<Animal> aList = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        RequestBody body = RequestBody.create("", MediaType.parse("text/plain"));
        Request request = new Request.Builder().url(url).method("POST", body).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        System.out.println("My Response: " + data);
        try {
            JSONObject json = new JSONObject(data);
            Iterator<String> keys = json.keys();
            while(keys.hasNext()) {
                String name = keys.next();
                String type = json.getJSONObject(name).getString("grouped_types").toString();
                String voice = json.getJSONObject(name).getString("grouped_voices").toString();
                String images = json.getJSONObject(name).getString("images").toString();
                aList.add(new Animal(name, type, voice, images));

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return aList;
    }
}
