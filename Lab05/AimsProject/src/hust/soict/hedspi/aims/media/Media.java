package hust.soict.hedspi.aims.media;
import java.util.Comparator;

public abstract class Media {

    private int id;
    private String title;
    private String category;
    private float cost;

    public Media(String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public static final Comparator<Media>
            COMPARE_BY_TITLE_COST =
            new MediaComparatorByTitleCost();

    public static final Comparator<Media>
            COMPARE_BY_COST_TITLE =
            new MediaComparatorByCostTitle();

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object obj) {

        // Cùng object
        if (this == obj) {
            return true;
        }

        // null hoặc khác kiểu
        if (obj == null ||
                !(obj instanceof Media)) {

            return false;
        }

        Media other = (Media) obj;

        // tránh NullPointerException
        if (this.getTitle() == null ||
                other.getTitle() == null) {

            return false;
        }

        // so sánh title
        return this.getTitle()
                .equals(other.getTitle());
    }
}