package hust.soict.hedspi.test.media;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class PolymorphismTest {

    public static void main(String[] args) {

        ArrayList<Media> mediae = new ArrayList<Media>();

        Book book = new Book(
                1,
                "Java",
                "Education",
                20.5f);

        DigitalVideoDisc dvd =
                new DigitalVideoDisc(
                        "Lion King",
                        "Animation",
                        "Disney",
                        90,
                        19.95f);

        CompactDisc cd =
                new CompactDisc(
                        2,
                        "Best Hits",
                        "Music",
                        15.5f,
                        0,
                        "Unknown",
                        "Artist");

        mediae.add(book);
        mediae.add(dvd);
        mediae.add(cd);

        for (Media media : mediae) {
            System.out.println(media.toString());
        }
    }
}