package SecondBlock.Task_1;

import java.awt.*;
import java.math.BigDecimal;
import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Point p1 = new Point(enter(scanner), enter(scanner));
        Point p2 = new Point(enter(scanner), enter(scanner));
        Point p3 = new Point(enter(scanner), enter(scanner));
        if (isTriangle(p1, p2, p3)) {
            System.out.println(true);
            System.out.println(isIsosceles(p1, p2, p3));
        }
    }

    private static boolean isTriangle(Point p1, Point p2, Point p3) {
        if (p1.equals(p2) | p1.equals(p3) | p2.equals(p3)) {
            return false;
        }
        BigDecimal x1 = new BigDecimal(p1.x);
        BigDecimal y1 = new BigDecimal(p1.y);
        BigDecimal x2 = new BigDecimal(p2.x);
        BigDecimal y2 = new BigDecimal(p2.y);
//        (p1.y - p2.y)*p3.x + (p2.x - p1.x)*p3.y + (p1.x*p2.y - p2.x*p1.y)
        BigDecimal result = y1.subtract(y2).multiply(new BigDecimal(p3.x)).add(x2.subtract(x1).multiply(new BigDecimal(p3.y))).add(x1.multiply(y2).subtract(x2.multiply(y1)));
        return result.intValue() != 0;
    }

    private static boolean isIsosceles(Point p1, Point p2, Point p3) {
        BigDecimal x1 = new BigDecimal(p1.x);
        BigDecimal y1 = new BigDecimal(p1.y);
        BigDecimal x2 = new BigDecimal(p2.x);
        BigDecimal y2 = new BigDecimal(p2.y);
        BigDecimal x3 = new BigDecimal(p3.x);
        BigDecimal y3 = new BigDecimal(p3.y);
        BigDecimal l1 = x1.subtract(x2).pow(2).add(y1.subtract(y2).pow(2));
        BigDecimal l2 = x1.subtract(x3).pow(2).add(y1.subtract(y3).pow(2));
        BigDecimal l3 = x2.subtract(x3).pow(2).add(y2.subtract(y3).pow(2));
        return l1.equals(l2) | l1.equals(l3) | l2.equals(l3);
    }

    private static int enter(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            scanner.next();
        }
        return scanner.nextInt();
    }

}
