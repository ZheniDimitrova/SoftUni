package fundamentalsSeptember2022_04Methods_Exercises;

import java.util.Scanner;

public class P08_FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        double result = calculateFactorial(firstNum) * 1.00 / calculateFactorial(secondNum);

        System.out.printf("%.2f", result);
    }

    public static long calculateFactorial(int number) {
        long fact = 1;
        for (int index = 1; index <= number; index++) {
            fact = fact * index;
        }
        return fact;
    }
}
