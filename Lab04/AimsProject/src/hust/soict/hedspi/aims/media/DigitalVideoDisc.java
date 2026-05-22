package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc {

    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {

        super(
                ++nbDigitalVideoDiscs,
                title,
                "",
                0,
                0,
                "");
    }

    public DigitalVideoDisc(
            String title,
            String category,
            String director,
            int length,
            float cost) {

        super(
                ++nbDigitalVideoDiscs,
                title,
                category,
                cost,
                length,
                director);
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
}