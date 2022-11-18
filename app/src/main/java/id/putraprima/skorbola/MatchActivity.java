package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MatchActivity extends AppCompatActivity {
    TextView tvhometeam, tvawayteam;
    ImageView viewhometeam, viewawayteam;
    Button btnresult, btnreset;
    TextView scorehometeam, scoreawayteam;
    Button onehome, twohome, threehome;
    Button oneaway, twoaway, threeaway;
    TextView tvscorehome, tvscoreaway;

    Integer scorehome, scoreaway;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        Bitmap bitmap = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");
        Bitmap bitmaps = (Bitmap)this.getIntent().getParcelableExtra("Bitmaps");
        String hometeam = getIntent().getExtras().getString("hometeam");
        String awayteam = getIntent().getExtras().getString("awayteam");
        tvscorehome = findViewById(R.id.score_home);
        tvscoreaway = findViewById(R.id.score_away);
        tvhometeam = findViewById(R.id.txt_home);
        tvawayteam = findViewById(R.id.txt_away);
        viewhometeam =(ImageView) findViewById(R.id.home_logo);
        viewawayteam =(ImageView) findViewById(R.id.away_logo);
        btnresult = findViewById(R.id.btn_result);
        scorehometeam = findViewById(R.id.score_home);
        scoreawayteam = findViewById(R.id.score_away);
        onehome = findViewById(R.id.btn_add_home_one);
        twohome = findViewById(R.id.btn_add_home_two);
        threehome = findViewById(R.id.btn_add_home_three);
        oneaway = findViewById(R.id.btn_add_away_one);
        twoaway = findViewById(R.id.btn_add_away_two);
        threeaway = findViewById(R.id.btn_add_away_three);
        btnreset = findViewById(R.id.btn_reset);
        scorehome = Integer.parseInt(tvscorehome.getText().toString());
        scoreaway = Integer.parseInt(tvscoreaway.getText().toString());
        viewhometeam.setImageBitmap(bitmap);
        viewawayteam.setImageBitmap(bitmaps);
        tvhometeam.setText(hometeam);
        tvawayteam.setText(awayteam);
        onehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scorehome += 1;
                tvscorehome.setText(String.valueOf(scorehome));
            }
        });
        twohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scorehome += 2;
                tvscorehome.setText(String.valueOf(scorehome));
            }
        });
        threehome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scorehome += 3;
                tvscorehome.setText(String.valueOf(scorehome));
            }
        });
        oneaway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreaway += 1;
                tvscoreaway.setText(String.valueOf(scoreaway));
            }
        });
        twoaway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreaway += 2;
                tvscoreaway.setText(String.valueOf(scoreaway));
            }
        });
        threeaway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreaway += 3;
                tvscoreaway.setText(String.valueOf(scoreaway));
            }
        });
        btnreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scoreaway = 0;
                scorehome = 0;
                tvscorehome.setText(String.valueOf(scorehome));
                tvscoreaway.setText(String.valueOf(scoreaway));
            }
        });
        btnresult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent result = new Intent(MatchActivity.this, ResultActivity.class);
                result.putExtra("hometeam", tvhometeam.getText().toString());
                result.putExtra("hometeam", tvhometeam.getText().toString());
                result.putExtra("awayteam", tvawayteam.getText().toString());
                result.putExtra("scorehome", tvscorehome.getText().toString());
                result.putExtra("scoreaway", tvscoreaway.getText().toString());
                startActivity(result);
            }
        });
        //TODO
        //1.Menampilkan detail match sesuai data dari main activity
        //2.Tombol add score menambahkan satu angka dari angka 0, setiap kali di tekan
        //3.Tombol Cek Result menghitung pemenang dari kedua tim dan mengirim nama pemenang ke ResultActivity, jika seri di kirim text "Draw"
    }
}
