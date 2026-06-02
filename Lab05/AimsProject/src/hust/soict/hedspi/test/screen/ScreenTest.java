package hust.soict.hedspi.test.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.CartException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.StoreScreen;
import hust.soict.hedspi.aims.store.Store;

public class ScreenTest {

    public static void main(String[] args) throws CartException {

        Cart cart = new Cart();

        Store store = new Store();

        cart.addMedia(
                new DigitalVideoDisc(
                        "Interstellar",
                        "Sci-Fi",
                        "Christopher Nolan",
                        169,
                        30.95f
                )
        );

        // DVD
        store.addMedia(new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Allers",
                87,
                19.95f
        ));

        // DVD
        store.addMedia(new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                87,
                24.95f
        ));

        // DVD
        store.addMedia(new DigitalVideoDisc(
                "Avengers Endgame",
                "Action",
                "Anthony Russo",
                181,
                29.95f
        ));

        // DVD
        store.addMedia(new DigitalVideoDisc(
                "Interstellar",
                "Sci-Fi",
                "Christopher Nolan",
                169,
                30.95f
        ));

        // Book
        store.addMedia(new Book(
                "Clean Code",
                "Programming",
                15.50f
        ));

        // Book
        store.addMedia(new Book(
                "Sherlock Holmes",
                "Detective",
                12.95f
        ));

        // Book
        store.addMedia(new Book(
                "Harry Potter",
                "Fantasy",
                18.75f
        ));

        // CD
        store.addMedia(new Book(
                "Greatest Hits",
                "Music",
                14.95f
        ));

        // CD
        store.addMedia(new Book(
                "Classical Collection",
                "Classical",
                16.50f
        ));

        new StoreScreen(store, cart);
    }
}