package hust.soict.hedspi.garbage;

public class ConcatenationInLoops {

    public static void main(String[] args) {

        final int NUM_ITERATIONS = 100000;

        // String
        long start = System.currentTimeMillis();

        String s = "";
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            s += "0";
        }

        long end = System.currentTimeMillis();
        System.out.println("String time: " + (end - start) + " ms");

        // StringBuilder
        start = System.currentTimeMillis();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            sb.append("0");
        }

        end = System.currentTimeMillis();
        System.out.println("StringBuilder time: " + (end - start) + " ms");

        // StringBuffer
        start = System.currentTimeMillis();

        StringBuffer sbf = new StringBuffer();
        for (int i = 0; i < NUM_ITERATIONS; i++) {
            sbf.append("0");
        }

        end = System.currentTimeMillis();
        System.out.println("StringBuffer time: " + (end - start) + " ms");
    }
}