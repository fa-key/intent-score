package id.putraprima.skorbola;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getCanonicalName();
    private static final int LOGO_REQUEST_CODE = 1;
    private static final int AWAY_REQUEST_CODE = 2;
    private ImageView logoImage;
    private ImageView AwayImage;
    private EditText etHomeTeam;
    private EditText etAwayTeam;
    private Button btnOk;




    public void handleChangeLogo(View view) {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, LOGO_REQUEST_CODE);
    }
    public void handleChangeAway(View view) {
        Intent intents = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intents, AWAY_REQUEST_CODE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logoImage = findViewById(R.id.home_logo);
        AwayImage = findViewById(R.id.away_logo);
        etHomeTeam = findViewById(R.id.home_team);
        etAwayTeam = findViewById(R.id.away_team);
        btnOk = findViewById(R.id.btn_team);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logoImage.setDrawingCacheEnabled(true);
                AwayImage.setDrawingCacheEnabled(true);
                Bitmap b=logoImage.getDrawingCache();
                Bitmap c=AwayImage.getDrawingCache();
                Intent move = new Intent(MainActivity.this, MatchActivity.class);
                move.putExtra("hometeam", etHomeTeam.getText().toString());
                move.putExtra("awayteam", etAwayTeam.getText().toString());
                move.putExtra("Bitmap", b);
                move.putExtra("Bitmaps", c);
                startActivity(move);
            }
        });

        //TODO
        //Fitur Main Activity
        //1. Validasi Input Home Team -OK-
        //2. Validasi Input Away Team -OK=
        //3. Ganti Logo Home Team
        //4. Ganti Logo Away Team
        //5. Next Button Pindah Ke MatchActivity
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            Log.d(TAG, "Pilih gambar dicancel");
            return;
        }
        if (requestCode == LOGO_REQUEST_CODE) {
            if (data != null) {
                try {
                    Uri imageUri = data.getData();
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
                    logoImage.setImageBitmap(bitmap);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
        if (requestCode == AWAY_REQUEST_CODE) {
            if (data != null) {
                try {
                    Uri imageUris = data.getData();
                    Bitmap bitmaps = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUris);
                    AwayImage.setImageBitmap(bitmaps);
                } catch (IOException e) {
                    Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, e.getMessage());
                }
            }
        }
    }

}
