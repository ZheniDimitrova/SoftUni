package fundamentalsSeptember2022_04Methods_Exercises;

import java.util.Scanner;

public class P06_MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printMiddleCharacter(input);

    }

    public static void printMiddleCharacter(String text) {
        if (text.length() % 2 != 0) {
            System.out.println(text.charAt(text.length() / 2));
        } else {
            int firstSymbol = text.length() / 2 - 1;
            int secondSymbol = text.length() / 2;
            System.out.println(text.charAt(firstSymbol) + "" + text.charAt(secondSymbol));
        }
    }

}
