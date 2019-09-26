package MainTask_2.Task_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Task_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while (num < 1) {
            num = enter(scanner);
        }
        System.out.println(maxDigital(num));

        num = 0;
        while (num < 1) {
            num = enter(scanner);
        }
        System.out.println(isPalindrome(num));

        num = 0;
        while (num < 1) {
            num = enter(scanner);
        }
        System.out.println(isSimple(num));

        num = 0;
        while (num < 1) {
            num = enter(scanner);
        }
        ArrayList<Integer> simpleDividers = simpleDividers(num);
        for (Integer divider : simpleDividers) {
            System.out.print(divider+" ");
        }

        num = 0;
        while (num < 1) {
            num = enter(scanner);
        }
        int num_2 = 0;
        while (num_2 < 1) {
            num_2 = enter(scanner);
        }
        System.out.println(gcd(num, num_2));
        System.out.println(lcm(num, num_2));

        num = 0;
        while (num < 1) {
            num = enter(scanner);
        }
        System.out.println(differentDigitsCount(num));
    }

    public static byte maxDigital(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("num must be natural");
        }
        int maxDigit = 0;
        do {
            if (maxDigit < num % 10) {
                maxDigit = num % 10;
            }
        } while ((num /= 10) != 0);
        return (byte) maxDigit;
    }

    public static boolean isPalindrome(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("num must be natural");
        }
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(num));
        return stringBuilder.reverse().toString().equals(String.valueOf(num));
    }

    public static boolean isSimple(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("num must be natural");
        }
        if (num == 1) {
            return false;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int i = 3; i < Math.sqrt(num); i += 2) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static ArrayList<Integer> simpleDividers(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("num must be natural");
        }
        ArrayList<Integer> dividers = new ArrayList<>();
        if (num % 2 == 0) {
            dividers.add(2);
        }
        for (int i = 3; i <= num / 2; i += 2) {
            if (num % i == 0 && isSimple(i)) {
                dividers.add(i);
            }
        }
        return dividers;
    }

    public static int gcd(int a, int b) {
        if (a < 1 || b < 1) {
            throw new IllegalArgumentException("a and b must be natural");
        }
        int factor = 1;
        while (true) {
            if (a == 0 || b == 0) {
                return Integer.max(a, b) * factor;
            }
            if (a == b) {
                return a * factor;
            }
            if (a == 1 || b == 1) {
                return factor;
            }
            if (a % 2 == 0 && b % 2 == 0) {
                factor *= 2;
                a /= 2;
                b /= 2;
            }
            if (a % 2 == 0 && b % 2 != 0) {
                a /= 2;
            }
            if (b % 2 == 0 && a % 2 != 0) {
                b /= 2;
            }
            if (a % 2 != 0 && b % 2 != 0) {
                if (a >= b) {
                    a = (a - b) / 2;
                } else {
                    b = (b - a) / 2;
                }
            }
        }
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static byte differentDigitsCount(int num) {
        if (num < 1) {
            throw new IllegalArgumentException("num must be natural");
        }
        String s = String.valueOf(num);
        byte count = 0;
        for (byte i = 0; i < s.length(); i++) {
            boolean flag = true;
            for (byte j = (byte) (i + 1); flag && j < s.length() ; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    flag = false;
                }
            }
            if (flag) {
                count++;
            }
        }
        return count;
    }

    private static int enter(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

}
