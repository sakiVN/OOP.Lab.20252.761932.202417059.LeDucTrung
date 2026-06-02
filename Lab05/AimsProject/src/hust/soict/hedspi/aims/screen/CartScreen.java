package hust.soict.hedspi.aims.screen;

import javax.swing.JFrame;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {

    private Store store;
    private Cart cart;

    public CartScreen(Store store, Cart cart) {
        super();

        this.store = store;
        this.cart = cart;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Cart");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                try {
                    // Thay đổi đường dẫn thử nghiệm tại đây
                    java.net.URL fxmlLocation = getClass().getResource("/hust/soict/hedspi/aims/screen/cart.fxml");

                    // Bẫy lỗi trực quan nếu không tìm thấy file tài nguyên
                    if (fxmlLocation == null) {
                        javax.swing.JOptionPane.showMessageDialog(null,
                                "Không tìm thấy file cart.fxml! Hãy kiểm tra lại đường dẫn tài nguyên.",
                                "FXML Load Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    FXMLLoader loader = new FXMLLoader(fxmlLocation);
                    CartScreenController controller = new CartScreenController(store, cart, CartScreen.this);
                    loader.setController(controller);
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    fxPanel.setScene(scene);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}