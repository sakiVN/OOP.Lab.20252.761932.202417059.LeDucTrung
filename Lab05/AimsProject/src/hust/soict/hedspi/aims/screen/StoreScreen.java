package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class StoreScreen extends JFrame {

    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart) {

        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();

        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);

        setTitle("Store");

        setSize(1024, 768);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JPanel createNorth() {

        JPanel north = new JPanel();

        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));

        north.add(createMenuBar());
        north.add(createHeader());

        return north;
    }

    JMenuBar createMenuBar() {

        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addBook = new JMenuItem("Add Book");
        JMenuItem addCD = new JMenuItem("Add CD");
        JMenuItem addDVD = new JMenuItem("Add DVD");

        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuItem viewStore = new JMenuItem("View store");
        menu.add(viewStore);
        viewStore.addActionListener(e -> {
            new StoreScreen(this.store, this.cart);
            this.dispose();
        });

        JMenuItem viewCart = new JMenuItem("View cart");
        menu.add(viewCart);
        viewCart.addActionListener(e -> {
            new CartScreen(this.store, this.cart);
            this.dispose();
        });

        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(this.store, this.cart); // Truyền thêm đối tượng cart vào đây
            this.dispose();
        });

        addCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(this.store, this.cart); // Truyền thêm đối tượng cart vào đây
            this.dispose();
        });

        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(this.store, this.cart); // Truyền thêm đối tượng cart vào đây
            this.dispose();
        });

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));

        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {

        JPanel header = new JPanel();

        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");

        title.setFont(new Font(
                title.getFont().getName(),
                Font.PLAIN,
                50
        ));

        title.setForeground(Color.CYAN);

        JButton cartButton = new JButton("View cart");
        cartButton.addActionListener(e -> {
            new CartScreen(store, cart);
            this.dispose();
        });
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {

        JPanel center = new JPanel();

        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore =
                store.getItemsInStore();

        for (int i = 0;
             i < mediaInStore.size() && i < 9;
             i++) {

            MediaStore cell =
                    new MediaStore(
                            mediaInStore.get(i), cart);

            center.add(cell);
        }

        return center;
    }
}