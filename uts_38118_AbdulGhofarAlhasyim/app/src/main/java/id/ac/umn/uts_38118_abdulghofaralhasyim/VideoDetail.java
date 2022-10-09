package id.ac.umn.uts_38118_abdulghofaralhasyim;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoDetail extends AppCompatActivity {
    private ImageButton btnPlay;
    private TextView tvTitle;
    private TextView tvDesc;
    private LinearLayout control;
    private Handler handler;

    VideoView vw;

    MediaSessionCompat mediaSession;
    PlaybackStateCompat.Builder stateBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_detail);

        Intent detailIntent = getIntent();
        Bundle bundle = detailIntent.getExtras();
        SourceVideo ss = (SourceVideo) bundle.getSerializable("VideoDetail");
        String title = detailIntent.getStringExtra("VideoTitle");
        String desc = ss.getDescription();

        tvTitle = findViewById(R.id.tvTitle);
        tvTitle.setText(title);
        tvDesc = findViewById(R.id.tvDescription);
        tvDesc.setText(desc);

        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        vw = (VideoView)findViewById(R.id.videoView);
        vw.setMediaController(new MediaController(this));
        vw.setVideoURI(ss.getVideoURI());

        control = findViewById(R.id.control);

        btnPlay = findViewById(R.id.play);
        btnPlay.setOnClickListener(v -> {
            try {
                vw.start();
                handler = new Handler();
                handler.postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        control.setVisibility(View.INVISIBLE);
                    }
                }, 1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
