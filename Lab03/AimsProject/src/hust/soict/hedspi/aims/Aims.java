package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        // Tạo giỏ hàng
        Cart anOrder = new Cart();

        // Tạo các DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin");
        //dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // In tổng tiền
        System.out.println("Total cost is: " + anOrder.totalCost());

        // In lại tổng tiền
        System.out.println("Total cost after removal: " + anOrder.totalCost());
    }
}