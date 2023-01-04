package fundamentalsSeptember2022_02DataTypesAndVariables_Exercises;

import java.util.Scanner;

public class P04_SumOfChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        int sumChars = 0;

        for (int letter = 1; letter <= numberOfLines; letter++) {
            char currentLetter = scanner.nextLine().charAt(0);
            sumChars += currentLetter;

        }
        System.out.printf("The sum equals: %d", sumChars);
    }
}
