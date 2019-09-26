package MainTask_1.FirstBlock.Task_5;

import java.util.Scanner;

public class Task_5 {

    private final static int MAX_5_DIGITS_NUMBER = 99999;
    private final static int MIN_7_DIGITS_NUMBER = 1000000;
    private final static byte BASE_OF_DECIMAL = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isWrong = true;
        int n = 0;
        while (isWrong) {
            n = enter(scanner);
            if (n < MIN_7_DIGITS_NUMBER && n > MAX_5_DIGITS_NUMBER) {
                isWrong = false;
            }
        }
        float average = 0;
        double geometric = 1;
        byte count = 0;
        while (n > 0) {
            byte numeral = (byte) (n % BASE_OF_DECIMAL);
            average += numeral;
            geometric *= numeral;
            n /= BASE_OF_DECIMAL;
            count++;
        }
        average /= count;
        geometric = Math.pow(geometric, 1.0d/count);
        System.out.printf("average: %f\ngeometric: %f", average, geometric);
    }

    private static int enter(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

}
