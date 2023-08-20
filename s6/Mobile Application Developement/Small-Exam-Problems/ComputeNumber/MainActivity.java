package gr.uom.computenumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText number;
    public Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = number.getText().toString();
                if (!enteredText.isEmpty()) {
                    double number = Double.parseDouble(enteredText);
                    double result = Math.pow(number, 3);
                    // Εμφάνιση του μηνύματος με Toast
                    Toast.makeText(MainActivity.this, number + "power of 3 = " + result, Toast.LENGTH_SHORT).show();
            }
                else {
                    Toast.makeText(MainActivity.this, "Please enter a number", Toast.LENGTH_SHORT).show();
                }
        }
        });

        }
    }
