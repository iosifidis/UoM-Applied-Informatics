package gr.uom.thema_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    // Φτιάχνουμε 2 αντικείμενα (κείμενο και κουμπί)
    private EditText number;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Συνδέουμε την γραφική διεπαφή με τον κώδικα
        number = findViewById(R.id.number);
        button = findViewById(R.id.calc);

        // Παίρνουμε το κείμενο που έχει δωθεί από τον χρήστη
        String num = number.getText().toString();

        // Κάνουμε το κουμπί να μεταφερθεί στην επόμενη οθόνη
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSecondActivity(view);
            }
        });

    }

    // Στέλνουμε το κείμενο στην επόμενη οθόνη
    public void sendSecondActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("NUMBER", number.getText().toString());
        startActivity(intent);
    }
}