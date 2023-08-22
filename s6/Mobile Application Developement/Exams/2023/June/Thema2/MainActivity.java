package gr.uom.thema2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    // Εδώ η IP είναι από την εκφώνηση
    private final String IP = "192.168.1.104";
    private Spinner spinner;

    private MultiList multiList;
    private String image1, image2, oper1, oper2, res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        Button nextButton = (Button) findViewById(R.id.nextButton);

        multiList = new MultiList(IP);
        List<String> opers = multiList.getAllOpers();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, opers);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Log.d("MainActivity", "Number of items in adapter: " + arrayAdapter.getCount());
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selectedOper = (String) parentView.getItemAtPosition(position);
                Log.d("MainActivity", "onItemSelected called for position: " + position);
                image1 = multiList.getImage1(selectedOper);
                image2 = multiList.getImage2(selectedOper);
                oper1 = multiList.getOper1(selectedOper);
                oper2 = multiList.getOper2(selectedOper);
                res = multiList.getRes(selectedOper);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing here
            }
        });




        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSecondActivity(view);
            }
        });
    }

    public void sendSecondActivity(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("IMAGE1", image1);
        intent.putExtra("IMAGE2", image2);
        intent.putExtra("OPER1", oper1);
        intent.putExtra("OPER2", oper2);
        intent.putExtra("RES", res);
        startActivity(intent);
    }
}