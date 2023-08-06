package com.example.carpicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // το ορίζουμε εδώ για να το δούν όλες οι μέθοδοι.
    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Δημιουργείται το radiogroup
        rg = findViewById(R.id.modelPicker);
    }

    // Γράφουμε την μέθοδο για το τι θα κάνει το κουμπί όταν πατηθεί. Στα Attributes στο xml βάζω στο onClick αυτή τη μέθοδο
    public void onClickPickBrand(View v){
        // Δημιουργώ ένα νέο αντικείμενο που θέλω να γεμίσω με μοντέλα
        CarPickerSelector cps = new CarPickerSelector();

        // Φτιάχνω ένα αντικείμενο spinner. Επιλεγμένο αντικείμενο από την λίστα
        Spinner sp = findViewById(R.id.brandList);

        // Από το spinner παίρνω το επιλεγμένο αντικείμενο και το αποθηκεύω στο brand
        String brand = sp.getSelectedItem().toString();

        // Σύνδεση του GUI με την κλάση πρέπει να γίνει μέσα στην παρένθεση
        List<String> mList = cps.getCars(brand);


        // Πρέπει να περάσουμε τα μοντέλα στο GUI στο radiogroup
        rg.removeAllViews(); // το αδειάζουμε

        // κάνουμε έλεγχο αν είναι μια άδεια λίστα
        if (mList.size() == 0){
            // Αν είναι άδεια η λίστα να εμφανίζει ένα toast
            Toast myToast = Toast.makeText(
                getApplicationContext(),
                "There are no models for this brand!",
                        Toast.LENGTH_LONG
            );
            myToast.show();
            }
            else{
                // Μέθοδος που δέχεται το radiobutton και την λίστα που θέλουμε να προσθέσουμε. Την φτιάχνουμε στο main actiiviti
                createRadioButtons(rg, mList);

                // Φτιάχνω έναν Listener που θα τον υλοποιήσω εδώ μέσα
                rg.setOnCheckedChangeListener(
                        new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                                    // Φτιάχνω ένα αντικείμενο Radio button για να βρεί τι επέλεξα
                                    RadioButton rb = findViewById(checkedID);
                                    //  εμφανίζει ένα toast με το μοντέλο που επιλέχθηκε
                                    Toast myToast = Toast.makeText(
                                            getApplicationContext(),
                                            "The selected model is " + brand + " " + rb.getText(),
                                            Toast.LENGTH_LONG
                                    );
                                    myToast.show();

                                }

                        }
                );
            }
        }

        // Μέθοδος που θα χρησιμοποιήσω παραπάνω. Δέχεται το radiobutton και την λίστα που θέλουμε να προσθέσουμε
    private void createRadioButtons(RadioGroup rg, List<String> mList) {
        int count = mList.size(); // Παίρνω το μέγεθος της λίστας. Αυτό μπορεί να μπει και κατευθείαν στην κάτω σειρά στις αγγύλες.
        RadioButton rb[] = new RadioButton[count]; // Δημιουργώ ένα radio button (μέσα στην αγγύλη μπορώ να βάλω κατευθείαν το μέγεθος

        // Κατασκευή του radiobutton
        for (int i=0 ; i<mList.size(); i++){
            rb[i] = new RadioButton(this); // Φτιάχνω ένα radio button ανάλογα με τι μέγεθος θα έχει η λίστα
            rb[i].setText(mList.get(i)); // Προσθέτων το κείμενο που πήρα από την λίστα ως κείμενο σε radiobutton
            rb[i].setId(i+100); // Βάζω ένα id γιατί πιθανό να το ψάξω με το id
            rg.addView(rb[i]); // Το προσθέτω στο radiogroup
        }
    }

}