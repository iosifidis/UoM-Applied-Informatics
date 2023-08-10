package com.example.weatherapiactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WeatherFragment extends Fragment {

    // Αυτή η μεταβλητή αποθηκεύει μια σταθερά συμβολοσειρά με την ετικέτα "WeatherFragment".
    // Χρησιμοποιείται για αναφορά στο Fragment κατά την αποσφαλμάτωση ή την καταγραφή μηνυμάτων.
    private static final String TAG = "WeatherFragment";

    // Αυτή η μεταβλητή αποθηκεύει μια συμβολοσειρά με την περιγραφή "Current Weather".
    // Χρησιμοποιείται για να εμφανίσει την προεπιλεγμένη περιγραφή του καιρού.
    private String weatherString = "Current Weather";

    // Αυτή η μεταβλητή αναφέρεται σε ένα αντικείμενο TextView στο layout του Fragment.
    // Χρησιμοποιείται για να εμφανίσει το κείμενο που αναπαριστά τις πληροφορίες του καιρού.
    TextView textWeather;
    public WeatherFragment() {
    // Required empty public constructor
    }

    // Η μέθοδος onCreateView() χρησιμοποιείται για να δημιουργήσει και να επιστρέψει το layout που σχετίζεται με το Fragment.
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // φορτώνει το αντίστοιχο layout αρχείο (fragment_weather.xml) και δημιουργεί ένα αντικείμενο View με την ονομασία rootView που περιέχει τη σχετική διάταξη.
        View rootView = inflater.inflate(R.layout.fragment_weather, container, false);

        // ελέγχει αν υπάρχουν ορίσματα που περνιούνται στο Fragment μέσω μιας μεθόδου setArguments(Bundle).
        // Αν υπάρχουν, ανακτά την τιμή του ορίσματος με κλειδί "location" και την αποθηκεύει στη μεταβλητή weatherString.
        if (getArguments() != null) weatherString = getArguments().getString("location");

        // Διαφορετικά, η τιμή της weatherString θα είναι κενή.
        else weatherString = "";

        // αναφέρεται σε ένα αντικείμενο TextView με το αναγνωριστικό txtWeather που βρίσκεται στο layout του Fragment
        // και το αντιστοιχεί στην μεταβλητή textWeather.
        textWeather = rootView.findViewById(R.id.txtWeather);

        // ορίζει το κείμενο του TextView textWeather με την τιμή της μεταβλητής weatherString.
        textWeather.setText(weatherString);

        // επιστρέφει το αντικείμενο View (rootView) που περιέχει το σχετικό διάταξη, προκειμένου να εμφανιστεί στην οθόνη.
        return rootView;
    }

    // ο κώδικας δημιουργεί ένα νέο νήμα εκτέλεσης για να ανακτήσει τα δεδομένα και την πρόβλεψη και κατόπιν ενημερώνει το TextView textWeather με το αποτέλεσμα.
    @Override
    public void onStart() {
        // καλεί την αντίστοιχη μέθοδο στην υπερκλάση, εξασφαλίζοντας τη σωστή εκτέλεση των απαιτούμενων λειτουργιών.
        super.onStart();

        // εκτυπώνει την τιμή της μεταβλητής weatherString στην κονσόλα.
        System.out.println(weatherString);

        //  δημιουργεί ένα αντικείμενο της κλάσης FetchWeatherTask, περνώντας την τιμή της μεταβλητής weatherString ως παράμετρο κατασκευής.
        FetchWeatherTask weatherTask = new FetchWeatherTask(weatherString);

        // δημιουργεί ένα νέο νήμα εκτέλεσης (Thread) και το συσχετίζει με το αντικείμενο weatherTask, που υλοποιεί τον κώδικα που πρέπει να εκτελεστεί σε αυτό το νήμα.
        Thread t = new Thread(weatherTask);
        try {

            // ξεκινά την εκτέλεση του νήματος.
            t.start();

            // περιμένει μέχρι το νήμα να ολοκληρώσει την εκτέλεσή του πριν συνεχίσει η εκτέλεση του κώδικα.
            t.join();

            //  ορίζει το κείμενο του TextView textWeather με το αποτέλεσμα που έχει λάβει από το αντικείμενο weatherTask
            //  μέσω της μεθόδου getResult().
            textWeather.setText(weatherTask.getResult());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // η μέθοδος επιτρέπει τον δυναμικό ορισμό του κειμένου του TextView textWeather με μια νέα τιμή weatherString,
    // επιτρέποντας την ενημέρωση της εμφανιζόμενης πληροφορίας στο Fragment.
    public void setWeatherString(String weatherString) {

        // αναζητά το TextView με το αναγνωριστικό txtWeather στο ανώτερο Activity που περιέχει το Fragment.
        // Η μέθοδος getActivity() επιστρέφει το αντικείμενο Activity που περιβάλλει το Fragment.
        // Έπειτα, η μέθοδος findViewById(R.id.txtWeather) επιστρέφει το αντικείμενο TextView
        // που αντιστοιχεί στο αναγνωριστικό.
        TextView textWeather = getActivity().findViewById(R.id.txtWeather);

        // ορίζει το κείμενο του TextView textWeather με την τιμή weatherString.
        textWeather.setText(weatherString);
    }
}
