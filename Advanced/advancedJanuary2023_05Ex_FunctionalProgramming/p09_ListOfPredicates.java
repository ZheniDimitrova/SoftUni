package advancedJanuary2023_05Ex_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class p09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((number, list) -> {
            for (int num : list) {
                if (number % num != 0) {
                    return false;
                }
            }
            return true;
        });
        for (int num = 1; num <= n; num++) {
            if (isDivisible.apply(num, numbersList)) {
                System.out.print(num + " ");
            }
        }
    }
}
