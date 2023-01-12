package fundamentalsSeptember2022_04Methods_Exercises;

import java.util.Scanner;

public class P09_PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {

            if (isPalindromeInteger(input)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            input = scanner.nextLine();
        }
    }

    public static boolean isPalindromeInteger(String input) {
        String reversedInput = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversedInput += input.charAt(i);
        }
        return reversedInput.equals(input);
    }
}
