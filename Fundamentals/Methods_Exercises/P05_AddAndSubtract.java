package fundamentalsSeptember2022_04Methods_Exercises;

import java.util.Scanner;

public class P05_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int sumNumbers = getSum(firstNum, secondNum);
        int subtractNumbers = getSubtract(sumNumbers, thirdNum);

        System.out.println(subtractNumbers);

    }

    public static int getSum(int num1, int num2) {
        return num1 + num2;

    }

    public static int getSubtract(int num1, int num2) {
        return num1 - num2;
    }
}
