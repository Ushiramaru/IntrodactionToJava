package FirstBlock.Task_4;

import java.util.Scanner;

public class Task_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isWrong = true;
        short n = 0;
        while (isWrong) {
            n = enter(scanner);
            if (n < 10000 && n > 999) {
                isWrong = false;
            }
        }

        boolean isUp = true, isDown = true;
        while ((isDown | isUp) && (n / 10 != 0)) {
            byte numeral = (byte) (n % 10);
            n /= 10;
            isUp &= numeral > (n % 10);
            isDown &= numeral < (n % 10);
        }
        System.out.printf("isUp: %b\nisDown: %b", isUp, isDown);
    }

    private static short enter(Scanner scanner) {
        while (!scanner.hasNextShort()) {
            scanner.next();
        }
        return scanner.nextShort();
    }

}
