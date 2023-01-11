package fundamentalsSeptember2022_04Methods_LAB;

import java.util.Scanner;

public class P10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println((getMultiplyOfEvensAndOdds(Math.abs(number))));

    }

    public static int getMultiplyOfEvensAndOdds(int num) {

        int evenSum = getEvenSum(num);
        int oddSum = getOddSum(num);
        return getEvenSum(num) * getOddSum(num);
    }

    public static int getEvenSum(int num) {
        int evenSum = 0;

        while (num > 0) {
            int currentNum = num % 10;
            if (currentNum % 2 == 0) {
                evenSum += currentNum;
            }
            num = num / 10;
        }
        return evenSum;
    }

    public static int getOddSum(int num) {
        int oddSum = 0;

        while (num > 0) {
            int currentNum = num % 10;
            if (currentNum % 2 != 0) {
                oddSum += currentNum;
            }
            num = num / 10;
        }
        return oddSum;
    }
}
