import java.util.Scanner;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Số phần tử của mảng: ");
        int n = sc.nextInt();

        double[] arr = new double[n];

        // nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ "+ (i+1) + " = ");
            arr[i] = sc.nextDouble();
        }

        // tính tổng
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // sắp xếp
        Arrays.sort(arr);

        // trung bình
        double avg = sum / n;

        // in kết quả
        System.out.println("Sau sắp xếp: " + Arrays.toString(arr));
        System.out.println("Tổng: " + sum);
        System.out.println("Trung bình: " + avg);
    }
}