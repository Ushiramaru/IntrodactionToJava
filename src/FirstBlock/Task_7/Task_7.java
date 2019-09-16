package FirstBlock.Task_7;

import java.math.BigDecimal;
import java.util.Scanner;

public class Task_7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal a = new BigDecimal(enter(scanner));
        BigDecimal b = new BigDecimal(enter(scanner));
        a = a.add(b);
        b = a.subtract(b);
        a = a.subtract(b);
        System.out.printf("a: %d\nb: %d", a.intValue(), b.intValue());
    }

    private static int enter(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

}
