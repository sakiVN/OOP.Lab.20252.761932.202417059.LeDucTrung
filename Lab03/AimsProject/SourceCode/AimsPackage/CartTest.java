package AimsPackage;

public class CartTest {
    public static void main(String[] args) {

        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin");

        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        // 🔹 In giỏ hàng
        cart.print();

        // 🔹 Tìm theo ID
        System.out.println("\nSearch by ID:");
        cart.searchById(2);

        // 🔹 Tìm theo title
        System.out.println("\nSearch by title:");
        cart.searchByTitle("star");

        // 🔹 test không tìm thấy
        System.out.println("\nSearch not found:");
        cart.searchByTitle("abc");
    }
}