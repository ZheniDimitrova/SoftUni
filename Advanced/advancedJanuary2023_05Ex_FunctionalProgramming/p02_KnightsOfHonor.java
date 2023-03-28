package advancedJanuary2023_05Ex_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class p02_KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputNames = scanner.nextLine().split("\\s+");


        Consumer<String> printName = name -> System.out.println("Sir " + name);
        Arrays.stream(inputNames).forEach(printName);

    }
}
