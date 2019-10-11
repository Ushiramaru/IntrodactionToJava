package mainTask_1.secondBlock.task_3;

import java.io.IOException;

public class Task_3 {

    public static void main(String[] args) {
        try {
            char c = (char) System.in.read();
            System.out.printf("%b\n%b\n%b\n%b", isVowel1(c), isVowel2(c), isVowel3(c), isVowel4(c));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isVowel1(char c) {
        switch (c) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                    return false;
        }
    }

    private static boolean isVowel2(char c) {
        c = Character.toUpperCase(c);
        switch (c) {
            case 'A':
            case 'E':
            case 'I':
            case 'O':
            case 'U':
                return true;
            default:
                return false;
        }
    }

    private static boolean isVowel3(char c) {
        c = Character.toLowerCase(c);
        switch (c) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
            default:
                return false;
        }
    }

    private static boolean isVowel4(char c) {
        c = Character.toLowerCase(c);
        String str = ""+c;
        return str.matches("[aeiou]");
    }
}
