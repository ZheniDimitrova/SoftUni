package fundamentalsSeptember2022_04Methods_Exercises;

import java.util.Scanner;

public class P10_TopNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        for (int number = 1; number <= num; number++) {
            if (isDivisibleBy8(number) && atLeastOneOddDigit(number)) {
                System.out.println(number);
            }
        }
    }


    public static boolean isDivisibleBy8(int number) {
        int sumDigits = 0;

        while (number > 0) {
            int currentNum = number % 10;
            sumDigits += currentNum;
            number = number / 10;
        }
        return sumDigits % 8 == 0;
    }

    public static boolean atLeastOneOddDigit(int number) {
        while (number > 0) {
            int currentNum = number % 10;
            if (currentNum % 2 != 0) {
                return true;
            } else {
                number = number / 10;
            }
        }
        return false;
    }
}
