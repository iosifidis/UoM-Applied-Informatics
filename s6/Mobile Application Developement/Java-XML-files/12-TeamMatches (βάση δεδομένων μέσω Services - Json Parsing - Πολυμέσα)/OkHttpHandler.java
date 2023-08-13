package gr.uom.teammatches;

import android.os.StrictMode;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import okhttp3.*;

public class OkHttpHandler {

    public OkHttpHandler() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }


    ArrayList<Team> populatePlayers(String url) throws Exception {
        ArrayList<Team> teamList = new ArrayList<>();
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        String data = response.body().string();
        System.out.println("My Response: " + data);
        try {
            JSONObject json = new JSONObject(data);
            Iterator<String> keys = json.keys();
            while(keys.hasNext()) {
                String brand = keys.next();
                String image = json.getJSONObject(brand).getString("emblem").toString();
                String models = json.getJSONObject(brand).getString("players").toString();
                String images = json.getJSONObject(brand).getString("images").toString();
                teamList.add(new Team(brand, image, models, images));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return teamList;
    }


    ArrayList<String> populateMatches(String url) {
        ArrayList<String> fixtures = new ArrayList<>();

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create("",mediaType);
        Request request = new Request.Builder()
                .url(url)
                .method("POST", body)
                .build();
        Response response;

        String data = null;
        try {
            response = client.newCall(request).execute();
            data = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            System.out.println("My Response: " + data);
            JSONObject json = new JSONObject(data);
            Iterator<String> keys = json.keys();
            while(keys.hasNext()) {
                String fixture = keys.next();
                fixtures.add(fixture);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return fixtures;
    }

}
