package com.example.weatherapiactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /* Ορίζεται ένας listener για κλικ κουμπιού και, όταν κάνετε κλικ στο κουμπί,
    ανακτά το κείμενο από μια προβολή κειμένου και ξεκινά μια νέα δραστηριότητα (SecondActivity)
    με το εισαγόμενο κείμενο μεταβιβασμένο ως επιπλέον πεδίο δεδομένων στην πρόθεση.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Καλεί τη μέθοδο onCreate της γονικής κλάσης για να εκτελέσει οποιαδήποτε απαραίτητη ρύθμιση για τη δραστηριότητα
        super.onCreate(savedInstanceState);

        // Ορίζει το αρχείο διάταξης activity_main.xml ως προβολή περιεχομένου για τη δραστηριότητα,
        // ορίζοντας τα στοιχεία της διεπαφής χρήστη.
        setContentView(R.layout.activity_main);

        // Ανακτά μια αναφορά στο κουμπί με το αναγνωριστικό btnSendName από τη διάταξη.
        Button buttonSend = findViewById(R.id.btnSendName);

        // Ανακτά μια αναφορά στην προβολή κειμένου με το id txtLocation από τη διάταξη.
        final TextView location = findViewById(R.id.txtLocation);

        // Ορίζει ένα OnClickListener στο buttonSend για να ακούει συμβάντα κλικ.
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Ανακτά το κείμενο που έχει εισαχθεί στην προβολή κειμένου τοποθεσίας και το μετατρέπει σε συμβολοσειρά.
                String givenName = location.getText().toString();

                // Δημιουργεί ένα Intent για πλοήγηση από την τρέχουσα δραστηριότητα (MainActivity) σε μια άλλη δραστηριότητα (SecondActivity).
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                // Προσθέτει ένα επιπλέον πεδίο δεδομένων στο intent, με ένα κλειδί "location" και την τιμή του εισαγόμενου ονόματος.
                intent.putExtra("location",givenName);

                // Ξεκινά τη SecondActivity περνώντας τη δημιουργημένη πρόθεση, η οποία πλοηγείται στη νέα δραστηριότητα.
                startActivity(intent);
            }
        });


    }
}