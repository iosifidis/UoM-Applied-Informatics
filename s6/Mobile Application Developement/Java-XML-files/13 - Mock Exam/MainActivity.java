package gr.uom.animals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String IP = "192.168.1.104";
    private RadioGroup rg;
    private AnimalList animalList;
    private String name, type, voice, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalList = new AnimalList(IP);

        rg = findViewById(R.id.radioGroup);
        Button button = (Button) findViewById(R.id.nextButton);

        List<String> allNames = animalList.getAllNames();
        for(int i=0;i<allNames.size();i++) {
            RadioButton rb = new RadioButton(this);
            rb.setText(allNames.get(i));
            rb.setId(100 + i);
            rg.addView(rb);
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = (RadioButton) findViewById(i);
                name = rb.getText().toString();
                type = animalList.getAnimalType(name);
                voice = animalList.getAnimalVoice(name);
                image = animalList.getAnimalImage(rb.getText().toString());
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