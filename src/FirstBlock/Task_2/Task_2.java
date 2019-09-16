package FirstBlock.Task_2;

import java.math.BigDecimal;
import java.util.Scanner;

public class Task_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal weight = new BigDecimal(enter(scanner));

        Converter converter = new Converter();
        System.out.printf("%f\n", converter.getMilligram(weight).doubleValue());
        System.out.printf("%f\n", converter.getGram(weight).doubleValue());
        System.out.printf("%f", converter.getTon(weight).doubleValue());
    }

    private static double enter(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            scanner.next();
        }
        return scanner.nextDouble();
    }

}
