package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import static id.ac.polinema.intentexercise.RegisterActivity.DATA_KEY;

public class ProfileActivity extends AppCompatActivity {

    private static final String TAG = RegisterActivity.class.getCanonicalName();
    private ImageView avatarImage;
    private TextView usernameInput;
    private TextView emailInput;
    private TextView homepageInput;
    private TextView aboutInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        avatarImage = findViewById(R.id.image_profile_activity);
        usernameInput = findViewById(R.id.label_fullname);
        emailInput = findViewById(R.id.label_email);
        homepageInput = findViewById(R.id.label_homepage);
        aboutInput = findViewById(R.id.label_about);

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            try {
                UserData userdata = getIntent().getParcelableExtra(DATA_KEY);
                usernameInput.setText(userdata.getFullName());
                emailInput.setText(userdata.getEmail());
                homepageInput.setText(userdata.getHomepage());
                aboutInput.setText(userdata.getAbout());
                Bitmap bit = MediaStore.Images.Media.getBitmap(this.getContentResolver(), userdata.getPath());
                avatarImage.setImageBitmap(bit);
            } catch (IOException e){
                Toast.makeText(this, "Can't load image", Toast.LENGTH_SHORT).show();
                Log.e(TAG, e.getMessage());
            }
        }
    }

    public void handleHomepage(View view) {
        String url = homepageInput.getText().toString();
        Intent inten = new Intent(Intent.ACTION_VIEW);
        inten.setData(Uri.parse("http://"+url));
        startActivity(inten);
    }
}
