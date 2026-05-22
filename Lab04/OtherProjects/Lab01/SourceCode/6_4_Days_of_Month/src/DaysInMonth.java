import java.util.Scanner;

public class DaysInMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int year;
        String month;
        int days = 0;

        // nhập năm
        while (true) {
            System.out.print("Enter year: ");
            if (sc.hasNextInt()) {
                year = sc.nextInt();
                if (year >= 0) break;
            } else {
                sc.next(); // bỏ input sai
            }
            System.out.println("[!] Invalid year, try again!");
        }

        sc.nextLine();

        // nhập tháng
        while (true) {
            System.out.print("Enter month: ");
            month = sc.nextLine().toLowerCase();

            switch (month) {
                case "1": case "jan": case "jan.": case "january":
                    days = 31; break;
                case "2": case "feb": case "feb.": case "february":
                    // kiểm tra năm nhuận
                    if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
                        days = 29;
                    else
                        days = 28;
                    break;
                case "3": case "mar": case "mar.": case "march":
                    days = 31; break;
                case "4": case "apr": case "apr.": case "april":
                    days = 30; break;
                case "5": case "may":
                    days = 31; break;
                case "6": case "jun": case "june":
                    days = 30; break;
                case "7": case "jul": case "july":
                    days = 31; break;
                case "8": case "aug": case "august":
                    days = 31; break;
                case "9": case "sep": case "sept": case "september":
                    days = 30; break;
                case "10": case "oct": case "october":
                    days = 31; break;
                case "11": case "nov": case "november":
                    days = 30; break;
                case "12": case "dec": case "december":
                    days = 31; break;
                default:
                    System.out.println("[!] Invalid month, try again!");
                    continue;
            }
            break;
        }

        System.out.println("Number of days: " + days);
    }
}