package com.trelous.musicalapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    // Creates keys for ListView
    public static final String KEY_SONG = "KEY_SONG";
    public static final String KEY_ALBUM = "KEY_ALBUM";
    public static final String KEY_ARTIST = "KEY_ARTIST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.songs);

        // Creates a list of songs, albums, and artists
        ArrayList<Songs> songs = new ArrayList<>();
        songs.add(new Songs("First We Take Manhattan", "I'm Your Man", "Leonard Cohen"));
        songs.add(new Songs("Ain't No Cure for Love", "I'm Your Man", "Leonard Cohen"));
        songs.add(new Songs("Everybody Knows", "I'm Your Man", "Leonard Cohen, Sharon Robinson"));
        songs.add(new Songs("I'm Your Man", "I'm Your Man", "Leonard Cohen"));
        songs.add(new Songs("Take This Waltz", "I'm Your Man", "Leonard Cohen, Federico Garcia Lorca"));
        songs.add(new Songs("Jazz Police", "I'm Your Man", "Leonard Cohen, Jeff Fisher"));
        songs.add(new Songs("I Can't Forget", "I'm Your Man", "Leonard Cohen"));
        songs.add(new Songs("Tower of Song", "I'm Your Man", "Leonard Cohen"));

        final SongAdapter adapter = new SongAdapter (this, songs);

        ListView listView = this.findViewById(R.id.list);

        listView.setAdapter(adapter);

        // ListView item is clicked, item is sent to a new activity
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Songs item = adapter.getItem(position);
                Intent Playing = new Intent(getApplicationContext(), Playing.class);
                assert item != null;
                Playing.putExtra(KEY_SONG, item.getSong());
                Playing.putExtra(KEY_ALBUM, item.getAlbum());
                Playing.putExtra(KEY_ARTIST, item.getArtist());
                startActivity(Playing);
            }
        });
    }
}
