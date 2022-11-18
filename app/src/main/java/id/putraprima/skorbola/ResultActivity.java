package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView tvWinning;
    Integer scorehometeam, scoreawayteam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        String hometeam = getIntent().getExtras().getString("hometeam");
        String awayteam = getIntent().getExtras().getString("awayteam");
        String scorehome = getIntent().getExtras().getString("scorehome");
        String scoreaway = getIntent().getExtras().getString("scoreaway");
        tvWinning = findViewById(R.id.textView3);
        scorehometeam = Integer.parseInt(scorehome);
        scoreawayteam = Integer.parseInt(scoreaway);
        if(scorehometeam>scoreawayteam) {
            tvWinning.setText(hometeam);
        }else{
            tvWinning.setText(awayteam);

        }
    }
}
