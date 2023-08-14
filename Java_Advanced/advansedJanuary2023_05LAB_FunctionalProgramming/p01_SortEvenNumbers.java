package advansedJanuary2023_05LAB_FunctionalProgramming;

import javax.management.StringValueExp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringNumbers = scanner.nextLine().split(", ");
        int[] numbers = new int[stringNumbers.length];

        for (int i = 0; i < stringNumbers.length; i++) {
            numbers[i] = Integer.parseInt(stringNumbers[i]);
        }
        List<Integer> evenNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenNumbers.add(numbers[i]);
            }
        }
        List<String> evenNumbersAsString = new ArrayList<>();
        for (int i = 0; i < evenNumbers.size(); i++) {
            evenNumbersAsString.add(String.valueOf(evenNumbers.get(i)));
        }
        System.out.println(String.join(", ", evenNumbersAsString));
    }
}
