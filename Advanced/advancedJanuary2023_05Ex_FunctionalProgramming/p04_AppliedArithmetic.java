package advancedJanuary2023_05Ex_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class p04_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        Function<List<Integer>, List<Integer>> addList = list -> list.stream().map(n -> n += 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiplyList = list -> list.stream().map(n -> n *= 2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtractList = list -> list.stream().map(n -> n -= 1).collect(Collectors.toList());
        Consumer<List<Integer>> printList = list -> list.forEach(n -> System.out.print(n + " "));

        while (!command.equals("end")) {

            switch (command) {
                case "add":
                    numbersList = addList.apply(numbersList);

                    break;
                case "multiply":
                    numbersList = multiplyList.apply(numbersList);

                    break;
                case "subtract":
                    numbersList = subtractList.apply(numbersList);

                    break;
                case "print":
                    printList.accept(numbersList);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
