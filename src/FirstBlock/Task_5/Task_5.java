package FirstBlock.Task_5;

import java.util.Scanner;

public class Task_5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isWrong = true;
        int n = 0;
        while (isWrong) {
            n = enter(scanner);
            if (n < 1000000 && n > 99999) {
                isWrong = false;
            }
        }
        float average = 0;
        double geometric = 1;
        byte count = 0;
        while (n > 0) {
            byte numeral = (byte) (n % 10);
            average += numeral;
            geometric *= numeral;
            n /= 10;
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
