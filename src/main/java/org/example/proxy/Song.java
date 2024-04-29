package org.example.proxy;

public class Song {
    private int id;
    private String title;
    private String artist;
    private String album;
    private int duration;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    private static int uniqueId = 0;

    int getUniqueId()
    {
        return uniqueId++;
    }
    public Song(String title, String artist, String album, int duration) {
        this.id = getUniqueId();
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public int getDuration() {
        return duration;
    }
    @Override
    public String toString() {
        return String.format("{Title: %s, artist: %s, album: %s, duration: %d (s)}",title,artist,album,duration);
    }
}
