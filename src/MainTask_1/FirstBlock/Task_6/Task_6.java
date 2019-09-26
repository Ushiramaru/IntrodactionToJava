package MainTask_1.FirstBlock.Task_6;

import java.util.Scanner;

public class Task_6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isWrong = true;
        String n = "";
        while (isWrong) {
            n = String.valueOf(enter(scanner));
            if (n.length() == 7) {
                isWrong = false;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(n);
        System.out.println(stringBuilder.reverse().toString());
    }

    private static int enter(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

}
