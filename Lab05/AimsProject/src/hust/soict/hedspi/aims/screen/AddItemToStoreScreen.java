package hust.soict.hedspi.aims.screen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.cart.Cart;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart; // Lưu thêm thuộc tính giỏ hàng để chuyển tiếp giữa các màn hình
    protected JPanel centerPanel;
    protected JTextField tfTitle, tfCategory, tfCost;

    public AddItemToStoreScreen(Store store, Cart cart, String titleHeader) {
        this.store = store;
        this.cart = cart;

        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setJMenuBar(createMenuBar());

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.X_AXIS));
        JLabel headerLabel = new JLabel(titleHeader);
        headerLabel.setFont(new Font(headerLabel.getFont().getName(), Font.PLAIN, 50));
        headerLabel.setForeground(Color.CYAN);
        headerPanel.add(Box.createRigidArea(new Dimension(10, 10)));
        headerPanel.add(headerLabel);
        this.add(headerPanel, BorderLayout.NORTH);

        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(0, 2, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        centerPanel.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        centerPanel.add(tfTitle);

        centerPanel.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        centerPanel.add(tfCategory);

        centerPanel.add(new JLabel("Cost:"));
        tfCost = new JTextField();
        centerPanel.add(tfCost);

        addCustomFields();

        JButton btnAdd = new JButton("Add Item");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnActionPressed();
            }
        });

        centerPanel.add(new JLabel(""));
        centerPanel.add(btnAdd);

        this.add(centerPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    protected abstract void addCustomFields();
    protected abstract void btnActionPressed();

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");
        JMenu smUpdateStore = new JMenu("Update Store");

        JMenuItem addCalBook = new JMenuItem("Add Book");
        JMenuItem addCalCD = new JMenuItem("Add CD");
        JMenuItem addCalDVD = new JMenuItem("Add DVD");

        smUpdateStore.add(addCalBook);
        smUpdateStore.add(addCalCD);
        smUpdateStore.add(addCalDVD);
        menu.add(smUpdateStore);

        JMenuItem viewStoreMenu = new JMenuItem("View store");
        menu.add(viewStoreMenu);

        // Truyền cả store và cart khi quay lại StoreScreen chính để không mất dữ liệu giỏ hàng
        viewStoreMenu.addActionListener(e -> {
            new StoreScreen(store, cart);
            this.dispose();
        });

        // Điều hướng sang các màn hình add tương ứng (có kèm theo cart)
        addCalBook.addActionListener(e -> { new AddBookToStoreScreen(store, cart); this.dispose(); });
        addCalCD.addActionListener(e -> { new AddCompactDiscToStoreScreen(store, cart); this.dispose(); });
        addCalDVD.addActionListener(e -> { new AddDigitalVideoDiscToStoreScreen(store, cart); this.dispose(); });

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
}