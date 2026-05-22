package hust.soict.hedspi.garbage;

public class NoGarbage {

    public static void main(String[] args) {

        StringBuffer buffer = new StringBuffer("Java");

        for (int i = 0; i < 100000; i++) {
            buffer.append(" programming");
        }

        System.out.println("Finished without creating much garbage");
    }
}