package advancedJanuary2023_05Ex_FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

       /* Consumer<List<Integer>> indexMinNumber = list -> System.out.println(list.lastIndexOf(Collections.min(list)));
        indexMinNumber.accept(numbersList);*/

        Function<List<Integer>, Integer> getIndexMinNumber = list -> list.lastIndexOf(Collections.min(list));
        System.out.println(getIndexMinNumber.apply(numbersList));
    }
}
