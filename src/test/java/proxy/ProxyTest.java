package proxy;

import org.example.proxy.Song;
import org.example.proxy.SongServerProxy;
import org.example.proxy.SongService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProxyTest {
    public long processTime(long startTime){
        long endTime = System.nanoTime();
        return endTime - startTime;
    }
    @Test
    public void songTest() {
        Song song1 = new Song("Sorry", "Justin Bieber", "Purpose", 2902);
        assertEquals(song1.getTitle(), "Sorry");
        assertEquals(song1.getArtist(), "Justin Bieber");
        assertEquals(song1.getAlbum(), "Purpose");
    }
    @Test
    public void searchByIdTest() {
        SongServerProxy songProxy = new SongServerProxy();
        songProxy.addNewSong(new Song("Sorry", "Justin Bieber", "Purpose", 2902));
        songProxy.addNewSong(new Song("Company", "Justin Bieber", "Purpose", 2682));
        Song result;
        long startTime =  System.nanoTime();
         result = songProxy.searchById(1);
        long processedTime = processTime(startTime);

        assertTrue(processedTime > 1000000000);

        startTime =  System.nanoTime();
        result = songProxy.searchById(1);
        processedTime = processTime(startTime);
        assertTrue(processedTime < 1000000000);



    }
    @Test
    public void searchByTitleTest() {
        SongServerProxy songProxy = new SongServerProxy();
        songProxy.addNewSong(new Song("Sorry", "Justin Bieber", "Purpose", 2902));
        songProxy.addNewSong(new Song("Company", "Justin Bieber", "Purpose", 2682));
        List<Song> result;
        long startTime =  System.nanoTime();
        result = songProxy.searchByTitle("Sorry");
        long processedTime = processTime(startTime);

        assertTrue(processedTime > 1000000000);

        startTime =  System.nanoTime();
        result = songProxy.searchByTitle("Sorry");
        processedTime = processTime(startTime);

        assertTrue(processedTime < 1000000000);


    }

}
