
import java.util.*;

class Playlist {
    private String[] songs;
    private int count;

    Playlist(int size) {
        songs = new String[size];
        count = 0;
    }

    public void addSong(String song) {
        if (count < songs.length) {
            songs[count] = song;
            count++;
        }
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, count);
    }

    public int getSongCount() {
        return count;
    }
}

public class PlaylistDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();

        Playlist p = new Playlist(size);

        for (int i = 0; i < n; i++) {
            p.addSong(sc.nextLine());
        }

        String[] copy = p.getSongs();

        System.out.println("Original Playlist:");
        for (String song : p.getSongs()) {
            System.out.println(song);
        }

        copy[0] = "Hacked";

        System.out.println("After modifying copied array:");
        for (String song : p.getSongs()) {
            System.out.println(song);
        }

        System.out.println("Song Count: " + p.getSongCount());

        sc.close();
    }
}
