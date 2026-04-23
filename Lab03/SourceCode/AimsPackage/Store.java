package AimsPackage;

public class Store {
    private static final int MAX_ITEMS_IN_STORE = 100;
    private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[MAX_ITEMS_IN_STORE];
    private int qtyInStore = 0;

    // 🔹 addDVD
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < MAX_ITEMS_IN_STORE) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD has been added to the store");
        } else {
            System.out.println("The store is full");
        }
    }

    // 🔹 removeDVD
    public void removeDVD(DigitalVideoDisc dvd) {
        boolean found = false;

        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                // dịch phần tử sang trái
                for (int j = i; j < qtyInStore - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyInStore - 1] = null;
                qtyInStore--;
                found = true;
                System.out.println("The DVD has been removed from the store");
                break;
            }
        }

        if (!found) {
            System.out.println("The DVD is not in the store");
        }
    }
}