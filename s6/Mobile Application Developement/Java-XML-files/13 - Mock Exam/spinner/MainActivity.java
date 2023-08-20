package gr.uom.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String IP = "192.168.1.104";
    private Spinner spinner;
    private AnimalList animalList;
    private String name, type, voice, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalList = new AnimalList(IP);

        spinner = findViewById(R.id.spinner);
        Button button = (Button) findViewById(R.id.nextButton);

        List<String> allNames = animalList.getAllNames();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, allNames);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String animalName = allNames.get(position);
                name = animalName;
                type = animalList.getAnimalType(animalName);
                voice = animalList.getAnimalVoice(animalName);
                image = animalList.getAnimalImage(animalName);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSecondActivity(view);
            }
        });

    }

    public void sendSecondActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("NAME", name);
        intent.putExtra("TYPE", type);
        intent.putExtra("VOICE", voice);
        intent.putExtra("IMAGE", image);
        startActivity(intent);
    }
}