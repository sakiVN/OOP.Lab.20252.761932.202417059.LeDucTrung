package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Disc extends Media implements Playable{

    private int length;
    private String director;

    public Disc(
            String title,
            String category,
            float cost) {

        super(title, category, cost);

        this.length = length;
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public void play() throws PlayerException {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}