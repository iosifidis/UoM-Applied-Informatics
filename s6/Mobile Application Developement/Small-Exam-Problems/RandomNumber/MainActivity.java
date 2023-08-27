package gr.uom.randomnumber;

import static android.app.PendingIntent.getActivity;

import static gr.uom.randomnumber.R.id.headerfirst;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView number;
    private TextView header;
    private Button abutton;

    private Button zbutton;
    private Button tbutton;
    private Button nbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ένωση με την γραφική διεπαφή
        number = findViewById(R.id.number);
        header = findViewById(R.id.headerfirst);
        abutton = findViewById(R.id.abutton);
        zbutton = findViewById(R.id.zbutton);
        tbutton = findViewById(R.id.toastBtn);
        nbutton = findViewById(R.id.nextbtn);

        // Τίτλος για ομορφιά
        header.setText("Καλώς ήλθες\n στην σούπερ εφρμογή για\n Random νουμέρια");

        // Ενέργεια του κουμπιού που θα προσθέτει 1 στο νούμερο
        abutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num = Integer.parseInt(number.getText().toString());
                num++;
//                number.setText(String.valueOf(num)); // Άλλος τρόπος για να εμφανίζει
                number.setText(num.toString());
            }

        });

        // Ενέργεια του κουμπιού που θα μηδενίζει το νούμερο
        zbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer num = Integer.parseInt(number.getText().toString());
                num = 0;
//                number.setText(String.valueOf(num));
                number.setText(num.toString());
            }

        });

        // Ενέργεια του κουμπιού που θα εμφανίζει ένα Toast
        tbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),
                        "Μπρό! Το νούμερο είναι το " + number.getText().toString()
                        , Toast.LENGTH_LONG).show();

            }

        });

        // Ένα listener για το κουμπί για μετακίνηση στην επόμενη οθόνη
        nbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSecondActivity(view);
            }
        });
    }

    // Μέθοδος που θα μετακινεί στην επόμενη οθόνη τα δεδομένα με Intent
    public void sendSecondActivity(View view){

      Integer arithmos = Integer.parseInt(number.getText().toString());

      // Φτιάχνουμε το Intent και τα στέλνουμε στο δεύτερο activity.
      Intent intent = new Intent(this, SecondActivity.class);
      intent.putExtra("ARITHMOS", arithmos.toString());
      startActivity(intent);
    }
}