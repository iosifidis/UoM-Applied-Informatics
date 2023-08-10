package com.example.weatherapiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/*
αυτός ο κώδικας ρυθμίζει το SecondActivity ανακτώντας την τοποθεσία από τα επιπλέον δεδομένα της πρόθεσης,
ορίζοντας την κατάλληλη προβολή κειμένου, δημιουργώντας μια δέσμη για τη διατήρηση ορισμάτων για ένα τμήμα
και αντικαθιστώντας ένα κοντέινερ θραύσματος με την παρουσία WeatherFragment που έχει τα δεδομένα τοποθεσίας ως ορίσματα.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Καλεί τη μέθοδο onCreate της γονικής κλάσης για να εκτελέσει οποιαδήποτε απαραίτητη ρύθμιση για τη δραστηριότητα.
        super.onCreate(savedInstanceState);

        // Ορίζει το αρχείο διάταξης activity_second.xml ως προβολή περιεχομένου για τη δραστηριότητα, ορίζοντας τα στοιχεία της διεπαφής χρήστη.
        setContentView(R.layout.activity_second);

        // Αντικείμενο Intent που περιέχει τα δεδομένα που έχουν σταλεί στη δραστηριότητα.
        Intent intent = getIntent();

        // Αντικείμενο στην προβολή κειμένου με το id txtGreeting από τη διάταξη.
        TextView txtGreeting = findViewById(R.id.txtGreeting);

        // Ανακτά την τιμή συμβολοσειράς που σχετίζεται με το κλειδί "location" από τα επιπλέον δεδομένα της πρόθεσης.
        String location = intent.getStringExtra("location");

        // Ρυθμίζει το κείμενο της προβολής κειμένου txtGreeting ώστε να εμφανίζει ένα μήνυμα χαιρετισμού με την τιμή τοποθεσίας που έχει ανακτηθεί.
        txtGreeting.setText("Temperature for "+location+ ":");

        // Δημιουργεί ένα νέο αντικείμενο Bundle για να διατηρεί ορίσματα για το τμήμα.
        Bundle bundle = new Bundle();

        // Προσθέτει την τιμή τοποθεσίας στο πακέτο χρησιμοποιώντας το κλειδί "location".
        bundle.putString("location", location);

        // Δημιουργεί μια νέα παρουσία του τμήματος WeatherFragment.
        WeatherFragment fragment = new WeatherFragment();

        // Ορίζει τα ορίσματα του WeatherFragment στο δημιουργημένο πακέτο, έτσι ώστε το τμήμα να έχει πρόσβαση στα δεδομένα τοποθεσίας.
        fragment.setArguments(bundle);

        // Ξεκινά μια συναλλαγή fragment χρησιμοποιώντας τη μέθοδο getSupportFragmentManager(), η οποία σας επιτρέπει να αλληλεπιδράτε με τμήματα εντός της δραστηριότητας.
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment2, fragment, "anyTagName").commit();
        // Αντικαθιστά το κοντέινερ τμήματος με το id fragment2 στη διάταξη με την παρουσία WeatherFragment και, στη συνέχεια, δεσμεύει τη συναλλαγή.
    }
}