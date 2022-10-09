package id.ac.umn.uts_38118_abdulghofaralhasyim;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements Signin.SinginListener {
    Button btnprofile;
    Button btnLibrary;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnprofile = findViewById(R.id.profile);
        btnLibrary = findViewById(R.id.btnlibrary);
        btnLibrary.setOnClickListener(v -> {
            openDialog();
        });
        btnprofile.setOnClickListener(v->{
            Intent profile = new Intent(MainActivity.this, Profile.class);
            startActivity(profile);
        });
    }

    public void openDialog() {
        Signin SigninView = new Signin();
        SigninView.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void SignInAction(String username) {
        Intent libraryIntent = new Intent(MainActivity.this, Library.class);
        libraryIntent.putExtra("NAME", username);
        startActivity(libraryIntent);
    }
}