package fundamentalsSeptember2022_08TextProcessing_LAB;

import java.util.Scanner;

public class P01_ReversedString_2Sb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("end")) {

            StringBuilder reversedStr = new StringBuilder();
            for (int i = input.length() - 1; i >= 0; i--) {
                char symbol = input.charAt(i);
                reversedStr.append(symbol);
            }
            System.out.printf("%s = %s%n", input, reversedStr);
            input = scanner.nextLine();
        }
    }
}
