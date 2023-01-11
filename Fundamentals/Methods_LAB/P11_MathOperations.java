package fundamentalsSeptember2022_04Methods_LAB;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P11_MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int secondNum = Integer.parseInt(scanner.nextLine());
        DecimalFormat df = new DecimalFormat("0.####");

        System.out.println(df.format(calculateMathOperations(firstNum, operator, secondNum)));


    }

    public static Double calculateMathOperations(int num1, String operator, int num2) {

        double result = 0;
        switch (operator) {
            case "/":
                result = num1 * 1.0 / num2;
                break;
            case "*":
                result = num1 * 1.0 * num2;
                break;
            case "+":
                result = num1 * 1.0 + num2;
                break;
            case "-":
                result = num1 * 1.0 - num2;
                break;
        }
        return result;
    }
}
