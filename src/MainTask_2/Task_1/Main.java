package MainTask_2.Task_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int throwCount = enter(scanner);
        HeadsOrTails headsOrTails = new HeadsOrTails(throwCount);
        System.out.printf("Throw count: %d\nHeads: %d\nTails: %d", headsOrTails.getThrowCount(), headsOrTails.getHeads(), headsOrTails.getTails());
    }

    private static int enter(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

}
