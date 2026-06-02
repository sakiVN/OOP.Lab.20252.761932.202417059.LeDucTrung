package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{

    public String artist;

    private ArrayList<Track> tracks = new ArrayList<Track>();

    /*public CompactDisc(
            int id,
            String title,
            String category,
            float cost,
            int length,
            String director,
            String artist) {

        super(id, title, category, cost, length, director);
        this.artist = artist;
    }*/

    public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
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

    @Override
    public void play() throws PlayerException {

        if (this.getLength() <= 0) {

            throw new PlayerException(
                    "ERROR: CD length is non-positive!"
            );
        }

        System.out.println(
                "Playing CD: " + this.getTitle()
        );
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