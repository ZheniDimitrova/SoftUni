package advancedJanuary2023_01LAB_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        ArrayDeque <String> parts = new ArrayDeque<>();
        Collections.addAll(parts, input);
        int result = 0;

        while(parts.size() > 1){
            int firstNumber = Integer.parseInt(parts.pop());
            String operator = parts.pop();
            int secondNumber = Integer.parseInt(parts.pop());

            if (operator.equals("+")){
                result = firstNumber + secondNumber;
            } else {
                result = firstNumber - secondNumber;
            }
            parts.push(String.valueOf(result));

        }

        System.out.println(parts.peek());
    }

    public static class p03_DecimalToBinaryConverter {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int number = Integer.parseInt(scanner.nextLine());

            ArrayDeque<Integer> binary = new ArrayDeque<>();

            if (number == 0){
                System.out.println(0);
            }
            while(number != 0 ){
                int leftover = number % 2;
                binary.push(leftover);
                number /= 2;
            }

            for (int num : binary){
                System.out.print(num);
            }

        }
    }
}
