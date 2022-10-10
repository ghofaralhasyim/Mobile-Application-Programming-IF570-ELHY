package id.ac.umn.uts_38118_abdulghofaralhasyim;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class Library extends AppCompatActivity{
    RecyclerView rvSourceVideo;
    LibraryAdapter mAdapter;
    ImageButton btnDelete;
    LinkedList<SourceVideo> listVideo = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library);

        Intent mainIntent = getIntent();
        String username = mainIntent.getStringExtra("NAME");
        Toast.makeText(Library.this,"Selamat Datang, " + username, Toast.LENGTH_LONG).show();
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle("Selamat datang,"+username);

        listContentVideo();

        rvSourceVideo = (RecyclerView) findViewById(R.id.RV);
        mAdapter = new LibraryAdapter(this, listVideo);
        rvSourceVideo.setAdapter(mAdapter);
        rvSourceVideo.setLayoutManager(new LinearLayoutManager(this));
        btnDelete = (ImageButton) findViewById(R.id.btnDelete);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.action_bar, menu);
        return true;
    }

    public void listContentVideo(){
        listVideo.add(new SourceVideo("Mantra Hujan 1",
                "Video Description /n Lorem Ipsum dolor sit amet, consectetur adipiscing elti."
                , "android.resource://" + getPackageName() + "/" + R.raw.mantra_hujan));
        listVideo.add(new SourceVideo("Mantra Hujan 2",
                "Video Description 2/n Lorem Ipsum dolor sit amet, consectetur adipiscing elti."
                , "android.resource://" + getPackageName() + "/" + R.raw.mantra_hujan));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_profile) {
            Intent profileIntent = new Intent(Library.this, Profile.class);
            startActivity(profileIntent);
        } else if (id == R.id.menu_home) {
            Intent homeIntent = new Intent(Library.this, MainActivity.class);
            startActivity(homeIntent);
        }
        return super.onOptionsItemSelected(item);
    }


    public void openDialog() {
        Delete deleteView = new Delete();
        deleteView.show(getSupportFragmentManager(), "example dialog");
    }

}
