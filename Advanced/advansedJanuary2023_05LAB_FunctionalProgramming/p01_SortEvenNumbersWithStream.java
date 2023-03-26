package advansedJanuary2023_05LAB_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_SortEvenNumbersWithStream {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] stringNumbers = scanner.nextLine().split(", ");

        List<String> evenNumbers = Arrays.stream(stringNumbers)
                .map(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .map(e -> e.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers));

        evenNumbers = evenNumbers.stream()
                .map(Integer::parseInt)
                .sorted()
                .map(e -> e.toString())
                .collect(Collectors.toList());
        System.out.println(String.join(", ", evenNumbers));

    }
}
