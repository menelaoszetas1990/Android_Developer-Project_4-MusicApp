package com.example.android.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class ChoosePlaystyle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooseplaystyle);

        // What to do when the user clicks the button of All songs
        Button allSongs = (Button) findViewById(R.id.button1CP);

        allSongs.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent allSongs = new Intent(ChoosePlaystyle.this, NowPlaying.class);

                //sending the mode that the user chose
                allSongs.putExtra("mode", 1);
                // Start the new activity
                startActivity(allSongs);
            }
        });

        // What to do when the user clicks the button of Sorted By Artist
        Button sortedByArtist = (Button) findViewById(R.id.button2CP);

        sortedByArtist.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent sortedByArtist = new Intent(ChoosePlaystyle.this, NowPlaying.class);

                //sending the mode that the user chose
                sortedByArtist.putExtra("mode", 2);
                // Start the new activity
                startActivity(sortedByArtist);
            }
        });

        // What to do when the user clicks the button of Sorted By Album
        Button sortedByAlbum = (Button) findViewById(R.id.button3CP);

        sortedByAlbum.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent sortedByAlbum = new Intent(ChoosePlaystyle.this, NowPlaying.class);

                //sending the mode that the user chose
                sortedByAlbum.putExtra("mode", 3);
                // Start the new activity
                startActivity(sortedByAlbum);
            }
        });

        // What to do when the user clicks the button of Sorted By Artist
        Button playlists = (Button) findViewById(R.id.button4CP);

        playlists.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent playlists = new Intent(ChoosePlaystyle.this, NowPlaying.class);

                //sending the mode that the user chose
                playlists.putExtra("mode", 4);
                // Start the new activity
                startActivity(playlists);
            }
        });

    }
}
