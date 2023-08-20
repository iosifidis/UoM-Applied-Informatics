package gr.uom.mynameisentrytoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.enterName);
        message = findViewById(R.id.message);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String enteredText = name.getText().toString();
                message.setText("Your name is " + enteredText);

                // Εμφάνιση του μηνύματος με Toast
                Toast.makeText(MainActivity.this, "Your name is " + enteredText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}