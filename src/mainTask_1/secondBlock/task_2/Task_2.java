package mainTask_1.secondBlock.task_2;

import java.util.Scanner;

public class Task_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Dragon dragon = new Dragon(enter(scanner));
        System.out.printf("%d\n%d", dragon.getHeadCount(), dragon.getEyesCount());
    }

    private static int enter(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

}
