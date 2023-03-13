package advancedJanuary2023_01LAB_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p02_SimpleCalculator_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        ArrayDeque<String> expression = new ArrayDeque<>();

        for (int i = input.length -1; i >= 0; i--) {
            expression.push(input[i]);
        }
        int result = 0;
        while (expression.size() > 1) {
            int firstNum = Integer.parseInt(expression.pop());
            String operator = expression.pop();
            int secondNum = Integer.parseInt(expression.pop());
            switch (operator) {
                case "+":
                    result = firstNum + secondNum;
                    break;
                case "-":
                    result = firstNum - secondNum;
                    break;
            }
            expression.push(String.valueOf(result));
        }

        System.out.println(expression.peek());
    }
}
