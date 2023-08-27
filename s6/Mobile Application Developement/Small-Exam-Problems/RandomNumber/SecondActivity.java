package gr.uom.randomnumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private TextView header;
    private TextView num;

    private Button randomButton;
    private Button backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Ένωση με την γραφική διεπαφή
        header = findViewById(R.id.header);
        num = findViewById(R.id.arithmos);
        randomButton = findViewById(R.id.randomB);
        backbtn = findViewById(R.id.backbtn);

        // Εισαγωγή δεδομένων από την πρώτη οθόνη (με Intent)
        Intent intent = getIntent();
        String arithmos = intent.getStringExtra("ARITHMOS");


        Log.d("ARITHMOS", "The number from first activity is: " + arithmos);


        // Τίτλος ομορφιάς
        header.setText("Ο αριθμός θα είναι μεταξύ 0 και " + arithmos.toString());
        // Πρώτο μήνυμα για να εκεί που δειχνει το νούμερο
        num.setText("Μάστορα,\n πάτα το Ραντόμ");

        // Ενέργεια του κουμπιού που εμφανίζει ένα τυχαίο νούμερο
        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer count = Integer.parseInt(arithmos.toString());
                Random rand = new Random();
                Integer result = rand.nextInt(count +1);
                num.setText(result.toString());

            }

        });

        // Ενέργεια του κουμπιού που θα μας πηγαίνει στην πρώτη οθόνη
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}