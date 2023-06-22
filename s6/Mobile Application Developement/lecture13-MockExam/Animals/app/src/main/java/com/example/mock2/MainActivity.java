package com.example.mock2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String myIP = "192.168.1.104";
    private RadioGroup rg;
    private AnimalList animalList;
    private String name, type, voice, image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        animalList = new AnimalList(myIP);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nextButton = (Button) findViewById(R.id.button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSecondActivity(view);
            }
        });

        rg = (RadioGroup) findViewById(R.id.animalNames);
        List<String> allAnimals = animalList.getAllNames();

        for(int i=0;i<allAnimals.size();i++) {
            RadioButton rb = new RadioButton(this);
            rb.setText(allAnimals.get(i));
            rb.setId(100+i);
            rg.addView(rb);
        }

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton rb = (RadioButton) findViewById(i);
                name = rb.getText().toString();
                type = animalList.getAnimalType(rb.getText().toString());
                voice = animalList.getAnimalVoice(rb.getText().toString());
                image = animalList.getAnimalImage(rb.getText().toString());
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