package gr.uom.thema1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText number;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = number.getText().toString();
                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                    // number.setError("Please enter a number");
                } else {
                    double num = Double.parseDouble(input);
                    double sqrt = (double) Math.sqrt(num);

                    Toast.makeText(MainActivity.this, "SQRT(" + num + ") = " + sqrt, Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}