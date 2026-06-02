package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{

    private String artist;

    private ArrayList<Track> tracks = new ArrayList<Track>();

    public CompactDisc(
            int id,
            String title,
            String category,
            float cost,
            int length,
            String director,
            String artist) {

        super(id, title, category, cost, length, director);

        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {

        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Track added.");
        } else {
            System.out.println("Track already exists.");
        }
    }

    public void removeTrack(Track track) {

        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed.");
        } else {
            System.out.println("Track not found.");
        }
    }

    @Override
    public int getLength() {

        int total = 0;

        for (Track track : tracks) {
            total += track.getLength();
        }

        return total;
    }

    public void play() {

        System.out.println("Playing CD: " + getTitle());

        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public String toString() {

        return "DVD - "
                + getTitle()
                + " - "
                + getCategory()
                + " - "
                + getDirector()
                + " - "
                + getLength()
                + ": "
                + getCost()
                + " $";
    }
}