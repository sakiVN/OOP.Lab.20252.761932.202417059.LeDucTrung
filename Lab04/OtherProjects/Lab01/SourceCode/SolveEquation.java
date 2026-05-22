import javax.swing.JOptionPane;
public class SolveEquation {
    public static void main(String[] args) {

        int choice = Integer.parseInt(JOptionPane.showInputDialog(
                "Choose equation type:\n1. Linear (ax + b = 0)\n2. System of equations\n3. Quadratic"));

        switch (choice) {
            case 1:
                // giải phương trình bậc nhất
                double a, b;

                a = Double.parseDouble(JOptionPane.showInputDialog("Enter a:"));
                b = Double.parseDouble(JOptionPane.showInputDialog("Enter b:"));

                if (a == 0) {
                    if (b == 0) {
                        JOptionPane.showMessageDialog(null, "Infinite solutions");
                    } else {
                        JOptionPane.showMessageDialog(null, "No solution");
                    }
                } else {
                    double x = -b / a;
                    JOptionPane.showMessageDialog(null, "Solution: x = " + x);
                }
                break;
            case 2:
                // giải hệ phương trình
                double a11, a12, b1, a21, a22, b2;

                a11 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a11:",
                        "Enter values for the first equation:", JOptionPane.INFORMATION_MESSAGE));
                a12 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a12:",
                        "Enter values for the first equation:", JOptionPane.INFORMATION_MESSAGE));
                b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b1:",
                        "Enter values for the first equation:", JOptionPane.INFORMATION_MESSAGE));
                a21 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a21:",
                        "Enter values for the second equation:", JOptionPane.INFORMATION_MESSAGE));
                a22 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a22:",
                        "Enter values for the second equation:", JOptionPane.INFORMATION_MESSAGE));
                b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b2:",
                        "Enter values for the second equation:", JOptionPane.INFORMATION_MESSAGE));

                double D = a11 * a22 - a21 * a12;
                double D1 = b1 * a22 - b2 * a12;
                double D2 = a11 * b2 - a21 * b1;

                if (D != 0) {
                    double x1 = D1 / D;
                    double x2 = D2 / D;
                    JOptionPane.showMessageDialog(null,
                            "Solution:\nx1 = " + x1 + "\nx2 = " + x2);
                } else {
                    if (D1 == 0 && D2 == 0) {
                        JOptionPane.showMessageDialog(null, "Infinite solutions");
                    } else {
                        JOptionPane.showMessageDialog(null, "No solution");
                    }
                }
                break;

            case 3:
                // giải phương trình bậc hai
                double A, B, C;

                A = Double.parseDouble(JOptionPane.showInputDialog("(ax^2 + bx + c = 0) Enter a:"));
                B = Double.parseDouble(JOptionPane.showInputDialog("(ax^2 + bx + c = 0) Enter b:"));
                C = Double.parseDouble(JOptionPane.showInputDialog("(ax^2 + bx + c = 0) Enter c:"));

                if (A == 0) {
                    // fallback to linear
                    if (B == 0) {
                        if (C == 0) {
                            JOptionPane.showMessageDialog(null, "Infinite solutions");
                        } else {
                            JOptionPane.showMessageDialog(null, "No solution");
                        }
                    } else {
                        double x = -C / B;
                        JOptionPane.showMessageDialog(null, "Solution: x = " + x);
                    }
                } else {
                    double delta = B * B - 4 * A * C;

                    if (delta > 0) {
                        double x1 = (-B + Math.sqrt(delta)) / (2 * A);
                        double x2 = (-B - Math.sqrt(delta)) / (2 * A);
                        JOptionPane.showMessageDialog(null,
                                "Two distinct solutions:\nx1 = " + x1 + "\nx2 = " + x2);
                    } else if (delta == 0) {
                        double x = -B / (2 * A);
                        JOptionPane.showMessageDialog(null,
                                "Double root: x = " + x);
                    } else {
                        JOptionPane.showMessageDialog(null, "No real solution");
                    }
                }
                break;
            default:
                // báo lỗi
                JOptionPane.showMessageDialog(null, "Invalid choice!");
        }
    }
}