package hust.soict.hedspi.aims.media;

public class Disc extends Media implements Playable{

    private int length;
    private String director;

    public Disc(
            int id,
            String title,
            String category,
            float cost,
            int length,
            String director) {

        super(id, title, category, cost);

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
    public void play() {
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}