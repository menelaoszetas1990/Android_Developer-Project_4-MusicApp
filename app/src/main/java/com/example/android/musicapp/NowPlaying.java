package com.example.android.musicapp;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import static com.example.android.musicapp.R.id.songInfoButton;
import static com.example.android.musicapp.R.id.artistInfoButton;
import static com.example.android.musicapp.R.id.albumInfoButton;

public class NowPlaying extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nowplaying);

        Bundle bundle = getIntent().getExtras();
        int mode = bundle.getInt("mode");

        switch(mode){
            case 1:
                // allow only songs to be shown at the NowPlaying area
            case 2:
                // allow only artist to be shown at the NowPlaying area
            case 3:
                // allow only albums to be shown at the NowPlaying area
            case 4:
                // allow only playlists to be shown at the NowPlaying area
        }

        // What to do when the user clicks the button of Song Info
        Button songInfo = (Button) findViewById(songInfoButton);

        songInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.putExtra(SearchManager.QUERY, R.string.songInfo);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        // What to do when the user clicks the button of Artist Info
        Button artistInfo = (Button) findViewById(artistInfoButton);

        artistInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.putExtra(SearchManager.QUERY, R.string.artistInfo);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        // What to do when the user clicks the button of Album Info
        Button albumInfo = (Button) findViewById(albumInfoButton);

        albumInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.putExtra(SearchManager.QUERY, R.string.albumInfo);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

    }
}
