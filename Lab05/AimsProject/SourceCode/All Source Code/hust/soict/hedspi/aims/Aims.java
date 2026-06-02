package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class Aims {

    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        initializeStore();

        int choice;

        do {

            showMenu();

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    viewStore(scanner);
                    break;

                case 2:
                    updateStore(scanner);
                    break;

                case 3:
                    cartMenu(scanner);
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        scanner.close();
    }

    public static void showMenu() {

        System.out.println("\nAIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.print("Please choose a number: ");
    }

    // Sample:
    public static void initializeStore() {

        DigitalVideoDisc dvd =
                new DigitalVideoDisc(
                        "Lion King",
                        "Animation",
                        "Disney",
                        90,
                        19.95f);

        Book book =
                new Book(
                        1,
                        "Java Programming",
                        "Education",
                        25.5f);

        CompactDisc cd =
                new CompactDisc(
                        2,
                        "Best Hits",
                        "Music",
                        15.0f,
                        0,
                        "Unknown",
                        "Artist");

        store.addMedia(dvd);
        store.addMedia(book);
        store.addMedia(cd);
    }

    // View Store:
    public static void viewStore(Scanner scanner) {

        store.print();

        System.out.println("\nOptions:");
        System.out.println("1. Add media to cart");
        System.out.println("2. Play media");
        System.out.println("0. Back");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {

            case 1:

                System.out.print("Enter title: ");
                String title = scanner.nextLine();

                Media found = store.searchByTitle(title);

                if (found != null) {
                    cart.addMedia(found);
                } else {
                    System.out.println("Media not found.");
                }

                break;

            case 2:

                System.out.println("Play feature selected.");  // Chưa implement.
                break;

            case 0:
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    public static void updateStore(Scanner scanner) {

        System.out.println("\n1. Add media");
        System.out.println("2. Remove media");

        int option = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter title: ");
        String title = scanner.nextLine();

        Media media = store.searchByTitle(title);

        switch (option) {

            case 1:

                if (media != null) {
                    store.addMedia(media);
                }

                break;

            case 2:

                if (media != null) {
                    store.removeMedia(media);
                }

                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    public static void cartMenu(Scanner scanner) {

        cart.print();

        System.out.println("\nCart Options:");
        System.out.println("1. Filter media");
        System.out.println("2. Sort media");
        System.out.println("3. Remove media");
        System.out.println("4. Play media");
        System.out.println("5. Place order");
        System.out.println("0. Back");

        int option = scanner.nextInt();
        scanner.nextLine();

        switch (option) {

            case 1:

                System.out.print("Enter title: ");
                String title = scanner.nextLine();

                cart.searchByTitle(title);

                break;

            case 2:

                sortMenu(scanner);

                break;

            case 3:

                System.out.print("Enter title: ");
                String removeTitle = scanner.nextLine();

                Media media =
                        store.searchByTitle(removeTitle);

                if (media != null) {
                    cart.removeMedia(media);
                }

                break;

            case 4:

                System.out.println("Play media selected.");
                break;

            case 5:

                System.out.println(
                        "An order has been created.");

                break;

            case 0:
                break;

            default:
                System.out.println("Invalid option.");
        }
    }

    public static void sortMenu(Scanner scanner) {

        System.out.println("\nSort by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");

        int option = scanner.nextInt();

        switch (option) {

            case 1:
                cart.sortByTitleCost();
                break;

            case 2:
                cart.sortByCostTitle();
                break;

            default:
                System.out.println("Invalid option.");
        }
    }
}