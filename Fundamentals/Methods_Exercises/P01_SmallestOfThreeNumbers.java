package fundamentalsSeptember2022_04Methods_Exercises;

import java.util.Scanner;

public class P01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        printSmallestOfThreeNumbers(firstNumber, secondNumber, thirdNumber);
    }

    public static void printSmallestOfThreeNumbers(int firstNum, int secondNum, int thirdNum) {
        if (firstNum <= secondNum && firstNum <= thirdNum) {
            System.out.println(firstNum);
        } else if (secondNum <= firstNum && secondNum <= thirdNum) {
            System.out.println(secondNum);
        } else  {
            System.out.println(thirdNum);
        }
    }
}

