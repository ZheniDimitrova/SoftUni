package fundamentalsSeptember2022_08TextProcessing_Exercises;

import java.util.Scanner;

public class P08_LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");
        double totalSum = 0;


        for (int i = 0; i < line.length; i++) {
            String code = line[i];

            char firstLetter = code.charAt(0);
            char secondLetter = code.charAt(code.length() - 1);
            double number = Double.parseDouble(code.replace(firstLetter, ' ').replace(secondLetter, ' ').trim());

            if (Character.isUpperCase(firstLetter)) {
                int alphabetPositionUpper = (int) firstLetter - 64;
                number /= alphabetPositionUpper;
            } else {
                int alphabetPositionLower = (int) firstLetter - 96;
                number *= alphabetPositionLower;
            }

            if (Character.isUpperCase(secondLetter)) {
                int alphabetPositionUpper = (int) secondLetter - 64;
                number -= alphabetPositionUpper;
            } else {
                int alphabetPositionLower = (int) secondLetter - 96;
                number += alphabetPositionLower;
            }
            totalSum += number;
        }
        System.out.printf("%.2f", totalSum);
    }
}
