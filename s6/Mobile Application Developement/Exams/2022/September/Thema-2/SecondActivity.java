package gr.uom.thema_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    // Εδώ βάζουμε ένα κείμενο και ένα κουμπί ως αντικείμενα
    private TextView result;
    private Button backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Συνδέουμε την γραφική διεπαφή με τον κώδικα
        result = findViewById(R.id.result);
        backbtn = findViewById(R.id.backbtn);

        // Παίρνουμε το κείμενο που έχει δωθεί από τον χρήστη από την πρώτη οθόνη
        Intent intent = getIntent();
        String a_num = intent.getStringExtra("NUMBER");

        // Φτιάχνουμε ένα αντικείμενο της κλάσης για να κόψει το κείμενο στην μέση
        StringMultiplier sm = new StringMultiplier(a_num);
        // Χρησιμοποιουμε την μέθοδο που θα πολλαπλασιάσει τους δυο αριθμούς
        double res = sm.multi();
        // Μετατρέπουμε το αποτέλεσμα σε String
        String finalres = String.valueOf(res);

        // Το παρουσιάζουμε στην οθόνη
        result.setText(a_num + " = " + finalres);

        // Βάζουμε το κουμπί να γυρνάει στην αρχική οθόνη (δεν το ζητάει)
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}