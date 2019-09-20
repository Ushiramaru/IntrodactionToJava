package FirstBlock.Task_4;

import java.util.Scanner;

public class Task_4 {

    private final static short MAX_3_DIGITS_NUMBER = 999;
    private final static short MIN_5_DIGITS_NUMBER = 10000;
    private final static byte BASE_OF_DECIMAL = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isWrong = true;
        short n = 0;
        while (isWrong) {
            n = enter(scanner);
            if (n < MIN_5_DIGITS_NUMBER && n > MAX_3_DIGITS_NUMBER) {
                isWrong = false;
            }
        }

        boolean isUp = true, isDown = true;
        while ((isDown | isUp) && (n / BASE_OF_DECIMAL != 0)) {
            byte numeral = (byte) (n % BASE_OF_DECIMAL);
            n /= BASE_OF_DECIMAL;
            isUp &= numeral > (n % BASE_OF_DECIMAL);
            isDown &= numeral < (n % BASE_OF_DECIMAL);
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
