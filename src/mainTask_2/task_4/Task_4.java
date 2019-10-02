package mainTask_2.task_4;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

import mainTask_2.task_3.Task_3;

public class Task_4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        while (a < 1) {
            a = enter(scanner);
        }
        int b = 0;
        while (b < 1 || a >= b) {
            b = enter(scanner);
        }
        int[] number = new int[b - a + 1];
        for (int i = 0; i < number.length; i++) {
            number[i] = i + a;
        }
        for (int i = 0; i < number.length - 1; i++) {
            for (int j = i + 1; j < number.length; j++) {
                if (isFriendly(number[i], number[j])) {
                    System.out.println("" + number[i] + " " + number[j]);
                    break;
                }
            }
        }
    }

    public static boolean isFriendly(int a, int b) {
        if (a < 1 || b < 1) {
            throw new IllegalArgumentException("a and b must be natural");
        }
        ArrayList<Integer> dividers = Task_3.dividers(a);
        BigDecimal sum = new BigDecimal(0);
        for (Integer divider : dividers) {
            sum = sum.add(new BigDecimal(divider));
        }
        if (sum.equals(new BigDecimal(b))) {
            dividers = Task_3.dividers(b);
            sum = new BigDecimal(0);
            for (Integer divider : dividers) {
                sum = sum.add(new BigDecimal(divider));
            }
            return sum.equals(new BigDecimal(a));
        } else {
            return false;
        }
    }

    private static int enter(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

}
