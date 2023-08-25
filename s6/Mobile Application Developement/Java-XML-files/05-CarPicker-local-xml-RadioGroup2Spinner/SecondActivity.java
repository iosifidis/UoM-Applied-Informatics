package gr.uom.carpicker_xml_radio2spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button button;

    private Button pickModel;

    private Spinner dropdown;
    private CarBrandList cbl;

    private TextView selectedBrand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Ένωση με την γραφική διεπαφή
        button = (Button) findViewById(R.id.backButton);
        pickModel = (Button) findViewById(R.id.pickButton);
        dropdown = (Spinner) findViewById(R.id.cars);
        selectedBrand = findViewById(R.id.selectedBrand);

        // Στην συνέχεια λαμβάνουμε το Intent και το αποθηκεύουμε.
        Intent intent = getIntent();
        String a_brand = intent.getStringExtra("BRAND");
//        List<String> a_brands = getIntent().getStringArrayListExtra("BRANDS");
        cbl = new CarBrandList(getAssets());


        selectedBrand.setText("The selected brand is " + a_brand + ".");

        // Δημιουργεί έναν ArrayAdapter που θα χρησιμοποιηθεί για τη συμπλήρωση του Spinner με δεδομένα.
        // Ο ArrayAdapter αρχικοποιείται με την τρέχουσα δραστηριότητα (this), τον πόρο διάταξης
        // για κάθε στοιχείο Spinner και τη λίστα των brands που ελήφθησαν
        // από το CarBrandList cbl χρησιμοποιώντας τη μέθοδο getAllBrands.
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        cbl.getAllModels(a_brand));
        dropdown.setAdapter(arrayAdapter);

        // Ενέργεια επιλογής αντικειμένου από τον Spinner
 //       dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
 //           @Override
 //           public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
 //               String selectedOption = dropdown.getSelectedItem().toString();
 //               Toast.makeText(getApplicationContext(),
 //                       "The selected model is " + a_brand + ": " + selectedOption
 //                       , Toast.LENGTH_SHORT).show();
 //           }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//                // Τίποτα εδώ
//            }
//        });

	// Ένας listener στο Spinner. Με την επιλογή του, δείχνει στην οθόνη την επιλεγμένη τιμή.
        pickModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selectedOption = dropdown.getSelectedItem().toString();
                Toast.makeText(getApplicationContext(),
                        "The selected model is " + a_brand + ": " + selectedOption,
                        Toast.LENGTH_SHORT).show();
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
