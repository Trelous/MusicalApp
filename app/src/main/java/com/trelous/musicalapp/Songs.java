package com.trelous.musicalapp;

// Custom class for Songs.
// Reference: http://stacktips.com/tutorials/android/pass-a-data-from-one-activity-to-another-in-android
public class Songs {

    private String Song;
    private String Album;
    private String Artist;

    Songs(String song, String album, String artist) {
        Song = song;
        Album = album;
        Artist = artist;
    }

    public String getSong() {
        return Song;
    }

    public String getAlbum() {
        return Album;
    }

    public String getArtist() {
        return Artist;
    }
}
