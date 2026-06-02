package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;
import java.util.Collections;

import hust.soict.hedspi.aims.exception.CartException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Cart {
    private ArrayList<Media> itemsOrdered =
            new ArrayList<Media>();

    // Thêm DVD
    public void addMedia(Media media)
            throws CartException {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media has been added.");
        } else {
            System.out.println("The media already exists.");
            throw new CartException(
                    "Media already exists in cart!"
            );
        }
    }

    // Xóa DVD
    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The media has been removed.");
        } else {
            System.out.println("The media does not exist.");
        }
    }

    // Tính tổng tiền
    public float totalCost() {
        float total = 0;

        for (Media media : itemsOrdered) {
            total += media.getCost();
        }

        return total;
    }
    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        int i = 1;
        for (Media media : itemsOrdered) {
            System.out.println(i + ". " + media.toString());
            i++;
        }
        System.out.println("Total cost: " + totalCost() + " $");
        System.out.println("***************************************************");
    }

    // Searching:
    public void searchById(int id) {
        for (Media media : itemsOrdered) {
            if (media.getId() == id) {
                System.out.println(media.toString());
                return;
            }
        }
        System.out.println("No media found.");
    }

    public void searchByTitle(String title) {
        boolean found = false;
        for (Media media : itemsOrdered) {
            if (media.getTitle().toLowerCase()
                    .contains(title.toLowerCase())) {
                System.out.println(media.toString());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No media found.");
        }
    }

    public void sortByTitleCost() {

        Collections.sort(
                itemsOrdered,
                Media.COMPARE_BY_TITLE_COST);

        System.out.println(
                "The cart has been sorted by title.");
    }

    public void sortByCostTitle() {

        Collections.sort(
                itemsOrdered,
                Media.COMPARE_BY_COST_TITLE);

        System.out.println(
                "The cart has been sorted by cost.");
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}