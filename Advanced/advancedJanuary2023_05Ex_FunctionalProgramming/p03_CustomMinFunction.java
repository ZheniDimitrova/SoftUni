package advancedJanuary2023_05Ex_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        // начин 1 - без function programming
        //System.out.println(Collections.min(numbersList));

        //начин 2
        Consumer<List<Integer>> listConsumer = list -> System.out.println(Collections.min(list));
        listConsumer.accept(numbersList);

        //начин 3
       // Function<List<Integer>, Integer> getMinNumber = list -> Collections.min(list);
        //System.out.println(getMinNumber.apply(numbersList));
    }
}
