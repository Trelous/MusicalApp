package com.trelous.musicalapp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Songs> {

    SongAdapter(Activity context, ArrayList<Songs> songs) {
        super(context, 0, songs);
    }

    // Class to hold ArrayList Views.
    // Reference: https://dzone.com/articles/optimizing-your-listview
    private static class ViewHolder {
        private TextView songTextView;
        private TextView albumTextView;
        private TextView artistTextView;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {

        Songs currentSong = getItem(position);

        ViewHolder holder;

        // Checks if the view is being reused, otherwise inflate
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_main, parent, false);
            holder = new ViewHolder();

            // Find Song, Album, and Artist TextViews
            holder.songTextView = convertView.findViewById(R.id.song_text_view);
            holder.albumTextView = convertView.findViewById(R.id.album_text_view);
            holder.artistTextView = convertView.findViewById(R.id.artist_text_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Text to current Song object
        assert currentSong != null;
        holder.songTextView.setText(currentSong.getSong());

        // Text to current Album object
        holder.albumTextView.setText(currentSong.getAlbum());

        // Text to current Artist object
        holder.artistTextView.setText(currentSong.getArtist());

        // Return the whole list layout
        return convertView;
    }
}
