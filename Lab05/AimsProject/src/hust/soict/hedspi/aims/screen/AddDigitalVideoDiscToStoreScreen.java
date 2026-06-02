package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;
import javax.swing.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector, tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "ADD DVD TO STORE");
    }

    @Override
    protected void addCustomFields() {
        centerPanel.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        centerPanel.add(tfDirector);

        centerPanel.add(new JLabel("Length:"));
        tfLength = new JTextField();
        centerPanel.add(tfLength);
    }

    @Override
    protected void btnActionPressed() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = Float.parseFloat(tfCost.getText());
        String director = tfDirector.getText();
        int length = Integer.parseInt(tfLength.getText());

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this, "DVD added successfully!");
        new StoreScreen(store, cart); // Chuyển hướng kèm theo cart
        this.dispose();
    }
}