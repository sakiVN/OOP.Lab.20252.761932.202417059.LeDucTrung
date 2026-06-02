package hust.soict.hedspi.aims.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import javax.swing.JFrame;

public class CartScreenController {

    private Store store;
    private Cart cart;
    private JFrame parentFrame;
    private CartScreen cartScreen;

    private ObservableList<Media> mediaObservableList;
    private FilteredList<Media> filteredData;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label lblTotal;

    @FXML
    private MenuItem menuItemViewStore;

    @FXML
    private MenuItem menuItemViewCart;

    @FXML
    private Button btnStore;

    public CartScreenController(Store store, Cart cart, CartScreen cartScreen) {
        super();
        this.store = store;
        this.cart = cart;
        this.cartScreen = cartScreen;

        mediaObservableList =
                FXCollections.observableArrayList(
                        cart.getItemsOrdered()
                );
    }

    @FXML
    public void initialize() {

        btnPlay.setDisable(true);
        btnRemove.setDisable(true);

        ToggleGroup filterGroup = new ToggleGroup();
        radioBtnFilterId.setToggleGroup(filterGroup);
        radioBtnFilterTitle.setToggleGroup(filterGroup);

        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        filteredData = new FilteredList<>(mediaObservableList, p -> true);

        SortedList<Media> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(tblMedia.comparatorProperty());

        tblMedia.setItems(sortedData);

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia(newValue));

        tblMedia.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> updateButtonBar(newValue));

        updateTotal();
    }

    public void showFilteredMedia(String filter) {
        filteredData.setPredicate(media -> {
            if (filter == null || filter.isEmpty()) {
                return true;
            }
            String lowerCaseFilter = filter.toLowerCase();
            if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(lowerCaseFilter);
            }
            if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(lowerCaseFilter);
            }
            return true;
        });
    }

    void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setDisable(true);
            btnRemove.setDisable(true);
        } else {
            btnRemove.setDisable(false);
            btnPlay.setDisable(!(media instanceof Playable));
        }
    }

    @FXML
    void btnRemovePressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            mediaObservableList.remove(media);
            updateTotal();
        }
    }

    @FXML
    void btnPlayPressed() {

        Media media =
                tblMedia.getSelectionModel()
                        .getSelectedItem();

        if (media instanceof Playable playable) {

            try {

                playable.play();

                Alert alert =
                        new Alert(
                                Alert.AlertType.INFORMATION
                        );

                alert.setTitle("Playing Media");

                alert.setHeaderText(
                        media.getTitle()
                );

                alert.setContentText(
                        "Media is playing..."
                );

                alert.showAndWait();

            } catch (PlayerException e) {

                Alert alert =
                        new Alert(
                                Alert.AlertType.ERROR
                        );

                alert.setTitle("Player Error");

                alert.setHeaderText(
                        "Cannot play media"
                );

                alert.setContentText(
                        e.getMessage()
                );

                alert.showAndWait();
            }
        }
    }

    @FXML
    void btnPlaceOrderPressed() {
        if (cart.getItemsOrdered().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Place Order");
            alert.setHeaderText("No items in cart");
            alert.setContentText("Your cart is empty. Add items before placing an order.");
            alert.showAndWait();
            return;
        }
        cart.getItemsOrdered().clear();
        mediaObservableList.clear();
        updateTotal();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText("Order completed");
        alert.setContentText("Thank you for your purchase!");
        alert.showAndWait();
    }

    @FXML
    void btnStorePressed() {
        if (store != null) {
            new StoreScreen(store, cart);
            if (cartScreen != null) {
                cartScreen.setVisible(false);
            }
        }
    }

    @FXML
    void menuViewStorePressed() {
        if (store != null) {
            new StoreScreen(store, cart);
            cartScreen.setVisible(false);
        }
    }

    @FXML
    void menuViewCartPressed() {
        new CartScreen(store, cart);
    }

    private void updateTotal() {
        if (lblTotal != null) {
            lblTotal.setText(String.format("%.2f $", cart.totalCost()));
        }
    }
}