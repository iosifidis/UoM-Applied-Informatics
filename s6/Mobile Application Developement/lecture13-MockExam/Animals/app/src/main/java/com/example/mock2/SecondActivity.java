package com.example.mock2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button previousBtn = (Button) findViewById(R.id.button2);
        previousBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        TextView name = (TextView) findViewById(R.id.animalName);
        TextView type = (TextView) findViewById(R.id.animalType);
        TextView voice = (TextView) findViewById(R.id.animalVoice);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        Intent intent = getIntent();
        String a_name = intent.getStringExtra("NAME");
        String a_type = intent.getStringExtra("TYPE");
        String a_voice = intent.getStringExtra("VOICE");
        String a_image = intent.getStringExtra("IMAGE");

        name.setText(a_name);
        type.setText(a_type);
        voice.setText(a_voice);
        Picasso.with(getApplicationContext()).load(Uri.parse(a_image)).resize(300,
                0).into(imageView);

    }
}