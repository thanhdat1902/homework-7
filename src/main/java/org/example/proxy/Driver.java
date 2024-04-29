package org.example.proxy;

import java.util.List;

public class Driver {
    public static void main(String[] args) {
        SongServerProxy proxyServer = new SongServerProxy();
        Song songResult;
        List<Song> listSongResult;
        proxyServer.addNewSong(new Song("Sorry", "Justin Bieber", "Purpose", 2902));
        proxyServer.addNewSong(new Song("Company", "Justin Bieber", "Purpose", 2682));
        proxyServer.addNewSong(new Song("Love Yourself", "Justin Bieber", "Purpose", 3139));
        proxyServer.addNewSong(new Song("Maps", "Maroon 5", "V", 2931));
        proxyServer.addNewSong(new Song("Animals", "Maroon 5", "V", 2498));

        long startTime =  System.nanoTime();
        System.out.println("=================== Search By ID 1st time ===================");
        songResult = proxyServer.searchById(1);
        System.out.println(songResult);
        printTime(startTime);

        System.out.println("=================== Search By ID 2nd time ===================");
        startTime =  System.nanoTime();
        songResult = proxyServer.searchById(1);
        System.out.println(songResult);
        printTime(startTime);

        System.out.println("=================== Search By Title 1st time ===================");
        startTime =  System.nanoTime();
        listSongResult = proxyServer.searchByTitle("Company");
        System.out.println(listSongResult);
        printTime(startTime);

        System.out.println("=================== Search By Title 2nd time ===================");
        startTime =  System.nanoTime();
        listSongResult = proxyServer.searchByTitle("Company");
        System.out.println(listSongResult);
        printTime(startTime);

        System.out.println("=================== Search By Album 1st time ===================");
        startTime =  System.nanoTime();
        listSongResult = proxyServer.searchByAlbum("V");
        System.out.println(listSongResult);
        printTime(startTime);

        System.out.println("=================== Search By Album 2nd time ===================");
        startTime =  System.nanoTime();
        listSongResult = proxyServer.searchByAlbum("V");
        System.out.println(listSongResult);
        printTime(startTime);
    }
    public static void printTime(long startTime){
        long endTime = System.nanoTime();
        long runningTime = endTime - startTime;
        System.out.println("Searching time: " + runningTime + " (ns)");

    }
}