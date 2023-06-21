package gr.uom.teammatches;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class TeamDetails extends AppCompatActivity {
    private TeamList tl;
    private final int EMBLEMSIZE = 150;
    private final int ICONSIZE = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String teamNames[] = intent.getStringExtra("match").split("-");
        String myIp = intent.getStringExtra("ip");
        tl = new TeamList(myIp);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_details);

        ((TextView)findViewById(R.id.textHome)).setText(teamNames[0]);
        ((TextView)findViewById(R.id.textAway)).setText(teamNames[1]);

        ImageView imageHome = findViewById(R.id.imageHome);
        ImageView imageAway = findViewById(R.id.imageAway);

        Picasso.with(this).load(tl.getImageForTeam(teamNames[0])).resize(EMBLEMSIZE, 0).into(imageHome);
        Picasso.with(this).load(tl.getImageForTeam(teamNames[1])).resize(EMBLEMSIZE, 0).into(imageAway);

        LinearLayout layouts[] = new LinearLayout[2];

        layouts[0] = findViewById(R.id.homeLayout);
        layouts[1] = findViewById(R.id.awayLayout);
        int counter=0;

        for(int k = 0; k<2; k++) {
            HashMap<String,String> players = tl.getAllPlayers(teamNames[k]);
            for (String pname: players.keySet()){
                LinearLayout row = new LinearLayout(this);
                row.setGravity(Gravity.CENTER_VERTICAL);
                row.setPadding(4,8,0,8);
                row.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                TextView pText = new TextView(this);
                ImageView pImage = new ImageView(this);
                pImage.setLayoutParams(new LinearLayout.LayoutParams(ICONSIZE, ICONSIZE));

                Picasso.with(this).load(players.get(pname)).into(pImage);
                pImage.setId(1000+counter);

                pText.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                pText.setText(pname);
                pText.setPadding(4,0,4,0);
                pText.setSingleLine(false);
                pText.setMaxLines(3);
                pText.setId(1000+counter);


                pImage.setScaleType(ImageView.ScaleType.CENTER_CROP);

                row.addView(pImage);
                row.addView(pText);
                counter++;

                layouts[k].addView(row);
            }

        }
   }
}