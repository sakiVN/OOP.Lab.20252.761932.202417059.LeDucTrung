package hust.soict.hedspi.test.screen;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.screen.CartScreen;
import hust.soict.hedspi.aims.store.Store; // 1. Thêm import lớp Store của bạn

public class ScreenFXTest {

    public static void main(String[] args) {

        // 2. Khởi tạo kho lưu trữ Store mẫu cho hệ thống
        Store store = new Store();
        Cart cart = new Cart();

        // --- Thêm sản phẩm mẫu vào KHO HÀNG (STORE) ---
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 30.95f));
        store.addMedia(new Book("Clean Code", "Programming", 15.50f));
        store.addMedia(new Book("Design Patterns", "Programming", 20.00f));

        // --- Thêm sản phẩm mẫu vào GIỎ HÀNG (CART) ---
        // DVD
        try {
            cart.addMedia(new DigitalVideoDisc(
                    "The Lion King",
                    "Animation",
                    "Roger Allers",
                    87,
                    19.95f
            )); // Thừa hành xử lý bẫy ngoại lệ nếu addMedia của bạn cấu hình quăng exception [cite: 1426]
        } catch (Exception e) {
            e.printStackTrace();
        }

        // DVD
        try {
            cart.addMedia(new DigitalVideoDisc(
                    "Interstellar",
                    "Sci-Fi",
                    "Christopher Nolan",
                    169,
                    30.95f
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Book
        try {
            cart.addMedia(new Book(
                    "Clean Code",
                    "Programming",
                    15.50f
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // CD
        try {
            cart.addMedia(new CompactDisc(
                    "Greatest Hits",
                    "Music",
                    14.95f
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3. ĐIỀU CHỈNH QUAN TRỌNG: Truyền cả hai tham số store và cart vào hàm dựng
        new CartScreen(store, cart);
    }
}