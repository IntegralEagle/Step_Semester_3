import java.util.Arrays;

public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.songCount = 0;
    }

    public void addSong(String title) {
        if (songCount < songs.length) {
            songs[songCount] = title;
            songCount++;
        }
    }

    public String[] getSongs() {
        // Defensive copy returning only added songs
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return this.songCount;
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Songs in playlist: " + Arrays.toString(copy));

        // Modifying returned copy
        copy[0] = "Hacked";
        System.out.println("First song in playlist (after copy modification): " + p.getSongs()[0]); // Expected: "Song A"
        System.out.println("Song count: " + p.getSongCount()); // Expected: 2
    }
}