package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc {

    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {

        super(
                title,
                "",
                0
        );
    }

    public DigitalVideoDisc(
            String title,
            String category,
            String director,
            int length,
            float cost) {

        super(
                title,
                category,
                cost
        );
    }

    public boolean isMatch(String title) {
        return getTitle().toLowerCase().contains(title.toLowerCase());
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
    @Override
    public void play() throws PlayerException {

        if (this.getLength() <= 0) {

            throw new PlayerException(
                    "ERROR: DVD length is non-positive!"
            );
        }

        System.out.println(
                "Playing DVD: " + this.getTitle()
        );
    }
}