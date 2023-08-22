package gr.uom.thema_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Δηλώνουμε τα αντικείμενα κειμένου και κουμπιού.
    private EditText text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Σύνδεση της γραφικής διεπαφής με τον κώδικα.
        text = findViewById(R.id.enterText);
        button = findViewById(R.id.button);


        // Βάζουμε την ενέργεια που θα κάνει το κουμπί.
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Θα πάρει αυτά που έγραψε ο χρήστης
                String name = text.getText().toString();

                // Εμφάνιση του μηνύματος με Toast
                Toast.makeText(MainActivity.this, "WELCOME " + name, Toast.LENGTH_LONG).show();
            }
        });


    }
}