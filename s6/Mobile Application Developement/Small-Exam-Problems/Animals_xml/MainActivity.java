package gr.uom.animals_xml;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private AnimalList aList;
    private RadioGroup rg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aList = new AnimalList(getAssets());


        Spinner dropDown = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item,
                        aList.getAllAnimals());
        dropDown.setAdapter(arrayAdapter);

        Log.d("MainActivity", "Number of items in adapter: " + arrayAdapter.getCount());


    }

    public void PickAnimalOnClick(View v){

        Log.d("MainActivity", "PickAnimalOnClick method called");

        Spinner dropDown = (Spinner) findViewById(R.id.spinner);

        rg = (RadioGroup) findViewById(R.id.radiogroup);

        String species = String.valueOf(dropDown.getSelectedItem());

        Log.d("MainActivity", "Selected species: " + species);

        List<String> allNames = aList.getAllNames(species);

        Log.d("MainActivity", "List of all Names size: " + allNames.size());

        rg.removeAllViews();
        rg.setVisibility(View.VISIBLE);

        for(int i=0; i< allNames.size(); i++){
            RadioButton rb = new RadioButton(this);
            rb.setText(allNames.get(i));
            //rb.setId(100+1);
            rg.addView(rb);
        }


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId){
                RadioButton rb = (RadioButton) findViewById(checkedId);
                Toast.makeText(getApplicationContext(), "The selected animal is " + species +
                        " and the name is " + rb.getText(), Toast.LENGTH_LONG).show();
            }
        });

    }

}