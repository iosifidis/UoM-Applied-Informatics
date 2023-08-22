package gr.uom.thema2;

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
        String a_image1 = intent.getStringExtra("IMAGE1");
        String a_image2 = intent.getStringExtra("IMAGE2");
        String a_oper1 = intent.getStringExtra("OPER1");
        String a_oper2 = intent.getStringExtra("OPER2");
        String a_res = intent.getStringExtra("RES");

        String tempMsg = a_oper1 +" * " + a_oper2 + " = " + a_res;

        message.setText(tempMsg);
        double temp_res = Double.parseDouble(a_res);
        double temp_oper1 = Double.parseDouble(a_oper1);
        double temp_oper2 = Double.parseDouble(a_oper2);

        double temp = temp_oper1 * temp_oper2;

        if (temp != temp_res) {
            Picasso.with(getApplicationContext()).load(Uri.parse(a_image1)).resize(300, 0).into(eikona);
        } else {
            Picasso.with(getApplicationContext()).load(Uri.parse(a_image2)).resize(300, 0).into(eikona);
        }


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
}