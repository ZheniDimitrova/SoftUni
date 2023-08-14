package fundamentalsSeptember2022_04Methods_LAB;

import java.util.Scanner;

public class P04_Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                addNumbers(firstNum, secondNum);
                break;

            case "multiply":
                multiplyNumbers(firstNum, secondNum);
                break;

            case "subtract":
                subtractNumbers(firstNum, secondNum);
                break;

            case "divide":
                divideNumbers(firstNum, secondNum);
                break;

        }

    }

    public static void addNumbers(int num1, int num2) {
        int resultAdd = num1 + num2;
        System.out.println(resultAdd);
    }

    public static void multiplyNumbers(int num1, int num2) {
        int resultMultiply = num1 * num2;
        System.out.println(resultMultiply);
    }

    public static void subtractNumbers(int num1, int num2) {
        int resultSubtract = num1 - num2;
        System.out.println(resultSubtract);
    }

    public static void divideNumbers(int num1, int num2) {
        int resultDivide = num1 / num2;
        System.out.println(resultDivide);

    }
}
