package gr.uom.animals;

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

        TextView message = (TextView) findViewById(R.id.message);
        ImageView eikona = (ImageView) findViewById(R.id.image);
        Button backButton = (Button) findViewById(R.id.backButton);

        Intent intent = getIntent();
        String a_name = intent.getStringExtra("NAME");
        String a_type = intent.getStringExtra("TYPE");
        String a_voice = intent.getStringExtra("VOICE");
        String a_image = intent.getStringExtra("IMAGE");

        String tempMsg = "My Name is " + a_name + ", I am a " + a_type + " and I " + a_voice + ".";
        message.setText(tempMsg);

        Picasso.with(getApplicationContext()).load(Uri.parse(a_image)).resize(300,0).into(eikona);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
}