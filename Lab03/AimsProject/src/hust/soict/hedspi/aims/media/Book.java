package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {

    private ArrayList<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public void addAuthor(String authorName) {

        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println(authorName + " has been added.");
        } else {
            System.out.println(authorName + " already exists.");
        }
    }

    public void removeAuthor(String authorName) {

        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println(authorName + " has been removed.");
        } else {
            System.out.println(authorName + " does not exist.");
        }
    }

    @Override
    public String toString() {

        return "Book - "
                + getTitle()
                + " - "
                + getCategory()
                + ": "
                + getCost()
                + " $";
    }
}