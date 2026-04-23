package hust.soict.hedspi.garbage;

public class GarbageCreator {

    public static void main(String[] args) {

        String s = "Java";

        for (int i = 0; i < 100000; i++) {
            s += " programming";
        }

        System.out.println("Finished creating garbage");
    }
}