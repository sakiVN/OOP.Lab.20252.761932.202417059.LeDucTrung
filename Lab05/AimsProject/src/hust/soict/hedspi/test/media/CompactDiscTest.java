package hust.soict.hedspi.test.media;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;

public class CompactDiscTest {

    public static void main(String[] args) {

        CompactDisc cd = new CompactDisc(

                "Greatest Hits",
                "Music",
                15.5f);

        Track track1 = new Track("Song 1", 3);
        Track track2 = new Track("Song 2", 4);

        cd.addTrack(track1);
        cd.addTrack(track2);

        System.out.println("CD Length: " + cd.getLength());

        try {
            cd.play();
        } catch (hust.soict.hedspi.aims.exception.PlayerException e) {
            throw new RuntimeException(e);
        }
    }
}