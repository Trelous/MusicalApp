package com.trelous.musicalapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.trelous.musicalapp.MainActivity.KEY_SONG;
import static com.trelous.musicalapp.MainActivity.KEY_ALBUM;
import static com.trelous.musicalapp.MainActivity.KEY_ARTIST;
import static com.trelous.musicalapp.R.layout.playing;

public class Playing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(playing);

        String playingSong = "";
        String playingAlbum = "";
        String playingArtist = "";

        // Gets intent and ListView item data from MainActivity
        Intent intent = getIntent();
        if (null != intent) {
            playingSong = intent.getStringExtra(KEY_SONG);
            playingAlbum = intent.getStringExtra(KEY_ALBUM);
            playingArtist = intent.getStringExtra(KEY_ARTIST);
        }

        // Sets data to TextViews
        TextView playingSongText = findViewById(R.id.playing_song);
        playingSongText.setText(playingSong);

        TextView playingAlbumText = findViewById(R.id.playing_album);
        playingAlbumText.setText(playingAlbum);

        TextView playingArtistText = findViewById(R.id.playing_artist);
        playingArtistText.setText(playingArtist);

        final ImageView playButton = findViewById(R.id.play_button);

        // Switch Image between play and pause buttons when clicked.
        // Reference: https://stackoverflow.com/questions/32420565/android-changing-imageview-between-two-images-on-button-click-and-reclick
        playButton.setTag(1);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (playButton.getTag().equals(1)) {
                    playButton.setImageResource(R.drawable.pause_black_48);
                    playButton.setTag(2);
                } else {
                    playButton.setImageResource(R.drawable.play_arrow_black_48);
                    playButton.setTag(1);
                }

            }
        });

    }
}
