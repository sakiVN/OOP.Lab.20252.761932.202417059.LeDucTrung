package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {

    private ArrayList<Media> itemsInStore =
            new ArrayList<Media>();

    // addMedia
    public void addMedia(Media media) {

        if (!itemsInStore.contains(media)) {

            itemsInStore.add(media);

            System.out.println("The media has been added to the store");
        } else {

            System.out.println("The media already exists in the store");
        }
    }

    // removeMedia
    public void removeMedia(Media media) {

        if (itemsInStore.contains(media)) {

            itemsInStore.remove(media);

            System.out.println("The media has been removed from the store");
        } else {

            System.out.println("The media is not in the store");
        }
    }

    // print store
    public void print() {

        System.out.println("****************STORE****************");

        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }

        System.out.println("*************************************");
    }
}