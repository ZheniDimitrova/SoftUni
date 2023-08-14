package fundamentalsSeptember2022_02DataTypesAndVariables_LAB;

import java.util.Scanner;

public class P10_SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= number; i++) {
            int sumDigits = 0;
            int currentNum = i;

            while (currentNum > 0) {
                sumDigits += currentNum % 10;
                currentNum = currentNum / 10;

            }
            if (sumDigits == 5 || sumDigits == 7 || sumDigits == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }
        }
    }

}

