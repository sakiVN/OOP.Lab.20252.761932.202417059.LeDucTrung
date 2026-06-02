package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import javax.swing.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "ADD BOOK TO STORE");
    }

    @Override
    protected void addCustomFields() {
        centerPanel.add(new JLabel("Authors (comma separated):"));
        tfAuthors = new JTextField();
        centerPanel.add(tfAuthors);
    }

    @Override
    protected void btnActionPressed() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());

        Book book = new Book(title, category, cost);
        String[] authors = tfAuthors.getText().split(",");
        for (String author : authors) {
            book.addAuthor(author.trim());
        }

        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book added successfully!");
        new StoreScreen(store, cart); // Chuyển hướng kèm theo cart
        this.dispose();
    }
}