package gr.uom.carpicker_xml_spiner2radio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button button;

    private Spinner dropdown;
    private CarBrandList cbl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Στο αντικείμενο cbl περνάω το αρχείο με τα brands με την getAssets()
        cbl = new CarBrandList(getAssets());

        button = (Button) findViewById(R.id.pick_car);

        //Δημιουργούμε το Spinner και το γεμίζουμε με τα brands (xml)
        dropdown = (Spinner) findViewById(R.id.cars);

        // Δημιουργεί έναν ArrayAdapter που θα χρησιμοποιηθεί για τη συμπλήρωση του Spinner με δεδομένα.
        // Ο ArrayAdapter αρχικοποιείται με την τρέχουσα δραστηριότητα (this), τον πόρο διάταξης
        // για κάθε στοιχείο Spinner και τη λίστα των brands που ελήφθησαν
        // από το CarBrandList cbl χρησιμοποιώντας τη μέθοδο getAllBrands.
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_dropdown_item,
                        cbl.getAllBrands());
        dropdown.setAdapter(arrayAdapter);


        // Ένα listener για το κουμπί για μετακίνηση στην επόμενη οθόνη
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSecondActivity(view);
            }
        });
    }

    public void sendSecondActivity(View view){
        // Μετατρέπουμε την List<String> σε ArrayList<String> για να μπορεί να σταλεί.
//        List<String> brandsList = cbl.getAllBrands();
//        ArrayList<String> brandsArrayList = new ArrayList<>(brandsList);

        // Παίρνουμε την επιλογή του χρήστη στο spinner.
        String brand = String.valueOf(dropdown.getSelectedItem());

        // Φτιάχνουμε το Intent και τα στέλνουμε στο δεύτερο activity.
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("BRAND", brand);
//        intent.putStringArrayListExtra("BRANDS", brandsArrayList);
        startActivity(intent);
    }

}