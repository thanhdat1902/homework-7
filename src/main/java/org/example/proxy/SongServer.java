package org.example.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServer implements SongService{
    private final Map<Integer, Song> songTable = new HashMap<>();
    public SongServer() {
        // Some default Song in the server
        this.addNewSong(new Song("Chung ta cua tuong lai", "Son Tung MTP", "Sky Tour", 2560 ));
        this.addNewSong(new Song("Suit & Tie", "MCK", "99%", 2930));
        this.addNewSong(new Song("Em cua ngay hom qua", "Son Tung MTP", "Sky Tour", 2820));
        this.addNewSong(new Song("Photograph", "Ed Sheeran", "We", 3120));
        this.addNewSong(new Song("Show Me Love", "MCK", "99%", 2856));
    }
    public void addNewSong(Song song) {
        songTable.put(song.getId(), song);
    }
    @Override
    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        if(songTable.containsKey(songID)) {
            return songTable.get(songID);
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        List<Song> songTitle= new ArrayList<>();
        for(Integer songID: songTable.keySet()){
            Song song = songTable.get(songID);
            if(song.getTitle().equals(title)){
                songTitle.add(song);
            }
        }
        return songTitle;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {}
        List<Song> songTitle= new ArrayList<>();
        for(Integer songID: songTable.keySet()){
            Song song = songTable.get(songID);
            if(song.getAlbum().equals(album)){
                songTitle.add(song);
            }
        }
        return songTitle;
    }
}
