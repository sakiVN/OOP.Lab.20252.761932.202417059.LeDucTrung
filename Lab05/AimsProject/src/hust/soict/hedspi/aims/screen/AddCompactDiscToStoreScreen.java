package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import javax.swing.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "ADD CD TO STORE");
    }

    @Override
    protected void addCustomFields() {
        centerPanel.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        centerPanel.add(tfArtist);
    }

    @Override
    protected void btnActionPressed() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String artist = tfArtist.getText();

        CompactDisc cd = new CompactDisc(title, category, cost);
        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "CD added successfully!");
        new StoreScreen(store, cart); // Chuyển hướng kèm theo cart
        this.dispose();
    }
}