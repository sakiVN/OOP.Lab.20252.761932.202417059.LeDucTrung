package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {

    public static void main(String[] args) {

        Cart cart = new Cart();

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

        cart.addMedia(book);
        cart.addMedia(dvd);
        cart.addMedia(cd);

        cart.print();

        System.out.println("\nSORT BY TITLE:");
        cart.sortByTitleCost();
        cart.print();

        System.out.println("\nSORT BY COST:");
        cart.sortByCostTitle();
        cart.print();
    }
}