package com.example.weatherapiactivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class FetchWeatherTask implements Runnable{
    String result;
    String location = "Thessaloniki,Greece";

    // Κατασκευαστής
    public FetchWeatherTask(String location) {
        System.out.println("Location:"+location);
        if (location.length()>0)
            this.location = location;
    }
    /*
    Η μέθοδος getWeatherDataFromJson εξάγει συγκεκριμένα δεδομένα θερμοκρασίας από μια συμβολοσειρά JSON
    και δημιουργεί μια μορφοποιημένη συμβολοσειρά με τις πληροφορίες θερμοκρασίας.
    Η συμβολοσειρά που προκύπτει προστίθεται σε μια λίστα, η οποία στη συνέχεια επιστρέφεται ως έξοδος της μεθόδου.
     */

    // ορίζει μια μέθοδο με το όνομα getWeatherDataFromJson που λαμβάνει μια συμβολοσειρά JSON ως είσοδο
    // και επιστρέφει μια λίστα συμβολοσειρών που περιέχουν δεδομένα καιρού.
    private List<String> getWeatherDataFromJson(String jsonStr) throws JSONException {

        // Αρχικοποιεί ένα κενό ArrayList για να αποθηκεύει τα δεδομένα καιρού ως συμβολοσειρές.
        List<String> resultStrings = new ArrayList<>();

        // Δημιουργεί ένα JSONObject από τη συμβολοσειρά εισόδου JSON.
        JSONObject json = new JSONObject(jsonStr);

        // Ανακτά την τιμή του πεδίου "temp" από το "κύριο" αντικείμενο στο JSON. Η τιμή μετατρέπεται σε συμβολοσειρά.
        String temp = json.getJSONObject("main").getString("temp").toString();

        // Ανακτά την τιμή του πεδίου "temp_min" από το "κύριο" αντικείμενο στο JSON. Η τιμή μετατρέπεται σε συμβολοσειρά.
        String minTemp = json.getJSONObject("main").getString("temp_min").toString();

        // Ανακτά την τιμή του πεδίου "temp_max" από το "κύριο" αντικείμενο στο JSON. Η τιμή μετατρέπεται σε συμβολοσειρά.
        String maxTemp = json.getJSONObject("main").getString("temp_max").toString();

        // Κατασκευάζει μια συμβολοσειρά που συνδυάζει τη θερμοκρασία, την ελάχιστη θερμοκρασία και τη μέγιστη θερμοκρασία και την προσθέτει στη λίστα resultStrings.
        resultStrings.add("Temperature:" + temp + "\nForecast for Today: " + minTemp + " to " + maxTemp);

        // Επιστρέφει τη λίστα resultStrings που περιέχει τα δεδομένα καιρού.
        return resultStrings;
    }

    /*
    η μέθοδος run στέλνει ένα αίτημα HTTP στο OpenWeatherMap API για ανάκτηση δεδομένων καιρού για μια συγκεκριμένη τοποθεσία.
    Στη συνέχεια επεξεργάζεται την απόκριση για να εξαγάγει τις σχετικές πληροφορίες για τον καιρό και τις εκχωρεί
    στη μεταβλητή αποτελέσματος.
     */
    @Override
    public void run() {
        // Κατασκευάζει τη διεύθυνση URL για το αίτημα API, συμπεριλαμβανομένης της επιθυμητής τοποθεσίας,
        // της μορφής απόκρισης (JSON), των μονάδων θερμοκρασίας (μετρική) και του κλειδιού API (πχ f04ce723e4421a3a129a57a4450d429f).
        String url= "https://api.openweathermap.org/data/2.5/weather?q="+location+"&mode=json&units=metric&APPID=<YOUR_API_KEY_HERE>";

        // Δημιουργεί μια παρουσία της κλάσης OkHttpClient, η οποία είναι υπεύθυνη για την εκτέλεση αιτημάτων HTTP.
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        // Δημιουργεί ένα κενό σώμα αιτήματος.
        RequestBody body = RequestBody.create("", MediaType.parse("text/plain"));

        // Κατασκευάζει ένα αίτημα HTTP με το καθορισμένο URL, χρησιμοποιώντας τη μέθοδο POST και το κενό σώμα αιτήματος.
        Request request = new Request.Builder().url(url).method("POST", body).build();

        // Αρχικοποιεί ένα αντικείμενο Response για να αποθηκεύσει την απάντηση από το αίτημα API.
        Response response = null;

        try {
            // Εκτελεί το αίτημα HTTP και εκχωρεί την απάντηση στη μεταβλητή απόκρισης.
            response = client.newCall(request).execute();

            // Ανακτά το σώμα απόκρισης ως συμβολοσειρά.
            String data = response.body().string();
            try {
                // Προσπαθεί να αναλύσει τα δεδομένα καιρού από την απόκριση χρησιμοποιώντας τη μέθοδο getWeatherDataFromJson,
                // η οποία επιστρέφει μια λίστα με συμβολοσειρές δεδομένων καιρού.
                // Το πρώτο στοιχείο από τη λίστα εκχωρείται στη μεταβλητή αποτελέσματος.
                result = getWeatherDataFromJson(data).get(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Μέθοδος που επιστρέφει τη μεταβλητή αποτελέσματος.
    public String getResult() {
        return result;
    }
}
