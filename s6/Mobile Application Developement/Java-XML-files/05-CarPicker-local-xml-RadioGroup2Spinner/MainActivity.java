package gr.uom.carpicker_xml_radio2spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;

    private RadioGroup rg;
    private CarBrandList cbl;

    private String selectedBrand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ένωση με την γραφική διεπαφή
        rg = (RadioGroup) findViewById(R.id.car_radio);
        button = (Button) findViewById(R.id.pick_car);

        // Στο αντικείμενο cbl περνάω το αρχείο με τα brands με την getAssets()
        cbl = new CarBrandList(getAssets());

        // Σύνδεση του GUI με την κλάση. Πρέπει να λάβω όλες τις μάρκες σε λίστα από το αρχείο xml
        List<String> allBrands = cbl.getAllBrands();

        // Πρέπει να περάσουμε τα μοντέλα στο GUI στο radiogroup
        rg.removeAllViews(); // το αδειάζουμε

        // Κατασκευή του radiobutton
        for(int i=0;i<allBrands.size();i++) {
            RadioButton rb = new RadioButton(this); // Φτιάχνω ένα radio button ανάλογα με τι μέγεθος θα έχει η λίστα
            rb.setText(allBrands.get(i)); // Προσθέτων το κείμενο που πήρα από την λίστα ως κείμενο σε radiobutton
            rb.setId(100+i); // Βάζω ένα id γιατί πιθανό να το ψάξω με το id
            rg.addView(rb); // Το προσθέτω στο radiogroup
        }

        // Φτιάχνω έναν Listener που θα τον υλοποιήσω εδώ μέσα
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                // Φτιάχνω ένα αντικείμενο Radio button για να βρεί τι επέλεξα
                RadioButton rb = (RadioButton) findViewById(checkedId);
                // Assign the value to the selectedBrand variable
                selectedBrand = (String) rb.getText();
            }
        });

        // Ένα listener για το κουμπί για μετακίνηση στην επόμενη οθόνη
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSecondActivity(view);
            }
        });
    }

    public void sendSecondActivity(View view){

        // Φτιάχνουμε το Intent και τα στέλνουμε στο δεύτερο activity.
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("BRAND", selectedBrand);
        startActivity(intent);
    }
}