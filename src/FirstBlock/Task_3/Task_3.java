package FirstBlock.Task_3;

import java.math.BigDecimal;
import java.util.Scanner;

public class Task_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigDecimal r1 = null;
        BigDecimal r2 = null;
        boolean isWrong = true;
        while (isWrong) {
            r1 = new BigDecimal(enter(scanner));
            r2 = new BigDecimal(enter(scanner));
            if (r1.compareTo(r2) > 0) {
                isWrong = false;
            }
        }
        System.out.printf("%f", getRingArea(r1, r2).doubleValue());
    }

    private static double enter(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static BigDecimal getRingArea(BigDecimal r1, BigDecimal r2) {
        return r1.pow(2).subtract(r2.pow(2)).multiply(new BigDecimal(Math.PI));
    }

}
