package org.example.proxy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServerProxy implements SongService {
    private Map<String, List<Song>> cacheTitle = new HashMap<>();
    private Map<String, List<Song>> cacheAlbum = new HashMap<>();

    private Map<Integer, Song> cacheID = new HashMap<>();

    SongServer songServer = new SongServer();

    public SongServerProxy() {}

    public void addNewSong(Song song) {
        songServer.addNewSong(song);
    }

    @Override
    public Song searchById(Integer songID) {
        if (!cacheID.containsKey(songID)) {
            Song song = songServer.searchById(songID);
            if (song != null) {
                cacheID.put(songID, song);
            }
        }
        return cacheID.get(songID);
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (!cacheTitle.containsKey(title)) {
            cacheTitle.put(title, songServer.searchByTitle(title));
        }
        return cacheTitle.get(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (!cacheAlbum.containsKey(album)) {
            cacheAlbum.put(album, songServer.searchByAlbum(album));
        }
        return cacheAlbum.get(album);
    }
}
