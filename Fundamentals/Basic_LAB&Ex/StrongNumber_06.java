package fundamentalsSeptember2022_01Basic_Exercises;

import java.util.Scanner;

public class StrongNumber_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int enteredNumber = number;
        int sumFact = 0;

        while (number > 0) {
            int lastDigit = number % 10;
            int fact = 1;
            for (int i = 1; i <= lastDigit; i++) {
                fact = fact * i;
            }
            sumFact += fact;
            number = number / 10;
        }
        if (sumFact == enteredNumber) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
