package gr.uom.carpicker_xml_spiner2radio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private RadioGroup rg;
    private Button button;

    private CarBrandList cbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Ένωση με την γραφική διεπαφή
        rg = (RadioGroup) findViewById(R.id.car_radio);
        button = (Button) findViewById(R.id.backButton);

        // Στην συνέχεια λαμβάνουμε το Intent και το αποθηκεύουμε.
        Intent intent = getIntent();
        String a_brand = intent.getStringExtra("BRAND");
//        List<String> a_brands = getIntent().getStringArrayListExtra("BRANDS");
        cbl = new CarBrandList(getAssets());

        // Σύνδεση του GUI με την κλάση πρέπει να γίνει μέσα στην παρένθεση
        List<String> allModels = cbl.getAllModels(a_brand);

        // Πρέπει να περάσουμε τα μοντέλα στο GUI στο radiogroup
        rg.removeAllViews(); // το αδειάζουμε

        // Κατασκευή του radiobutton
        for(int i=0;i<allModels.size();i++) {
            RadioButton rb = new RadioButton(this); // Φτιάχνω ένα radio button ανάλογα με τι μέγεθος θα έχει η λίστα
            rb.setText(allModels.get(i)); // Προσθέτων το κείμενο που πήρα από την λίστα ως κείμενο σε radiobutton
            rb.setId(100+i); // Βάζω ένα id γιατί πιθανό να το ψάξω με το id
            rg.addView(rb); // Το προσθέτω στο radiogroup
        }

        // Φτιάχνω έναν Listener που θα τον υλοποιήσω εδώ μέσα
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Φτιάχνω ένα αντικείμενο Radio button για να βρεί τι επέλεξα
                RadioButton rb = (RadioButton) findViewById(checkedId);
                //  εμφανίζει ένα toast με το μοντέλο που επιλέχθηκε
                Toast.makeText(getApplicationContext(),
                        "The selected model is " + a_brand + ": " + rb.getText()
                        , Toast.LENGTH_SHORT).show();
            }
        });

        // Κουμπί επιστροφής
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}