package FirstBlock.Task_1;

import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = enter(scanner);
        double b = enter(scanner);
        double c = enter(scanner);

        if (compare(a, b, c)) {
            System.out.println("equal");
        } else {
            System.out.println("different");
        }
    }

    private static boolean compare(double a, double b, double c) {
        return a == b & a == c;
    }

    private static double enter(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            scanner.next();
        }
        return scanner.nextDouble();
    }

}
