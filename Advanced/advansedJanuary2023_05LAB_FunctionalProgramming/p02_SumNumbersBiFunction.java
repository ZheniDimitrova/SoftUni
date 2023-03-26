package advansedJanuary2023_05LAB_FunctionalProgramming;

import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;
import java.util.function.BiFunction;

public class p02_SumNumbersBiFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        System.out.println("Count = " + input.length);

        BiFunction<Integer, String, Integer> sumNumbers = (x, y) -> x + Integer.parseInt(y);
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum = sumNumbers.apply(sum, input[i]);
        }
        System.out.println("Sum = " + sum);
    }
}
