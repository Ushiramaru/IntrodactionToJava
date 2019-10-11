package mainTask_2.task_3;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Task_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (num < 1) {
            num = enter(scanner);
        }
        System.out.println(isPerfect(num));
    }

    public static boolean isPerfect(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("num must be natural");
        }
        ArrayList<Integer> dividers = dividers(num);
        BigDecimal sum = new BigDecimal(0);
        for (Integer divider : dividers) {
            sum = sum.add(new BigDecimal(divider));
        }
        return sum.equals(new BigDecimal(num));
    }

    public static ArrayList<Integer> dividers(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("num must be natural");
        }
        ArrayList<Integer> dividers = new ArrayList<>();
        dividers.add(1);
        if (num % 2 == 0) {
            dividers.add(2);
            for (int i = 3; i <= num / 2; i++) {
                if (num % i == 0) {
                    dividers.add(i);
                }
            }
        } else {
            for (int i = 3; i <= num / 2; i += 2) {
                if (num % i == 0) {
                    dividers.add(i);
                }
            }
        }
        return dividers;
    }

    private static int enter(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

}
