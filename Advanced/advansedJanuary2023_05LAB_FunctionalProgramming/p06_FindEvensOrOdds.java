package advansedJanuary2023_05LAB_FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class p06_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        String command = scanner.nextLine();

        int lowerBound = Integer.parseInt(input[0]);
        int upperBound = Integer.parseInt(input[1]);
        List<Integer> numbersList = new ArrayList<>();

        for (int i = lowerBound; i <= upperBound; i++) {
            numbersList.add(i);
        }

        Predicate<Integer> evenOddPredicate;
        if (command.equals("odd")) {
            evenOddPredicate = n -> n % 2 != 0;
        } else {
            evenOddPredicate = n -> n % 2 == 0;
        }


        numbersList.stream()
                .filter(evenOddPredicate)
                .forEach(n -> System.out.print(n + " "));
    }
}
