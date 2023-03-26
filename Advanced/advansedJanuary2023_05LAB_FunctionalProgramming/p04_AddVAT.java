package advansedJanuary2023_05LAB_FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class p04_AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] realNumbers = scanner.nextLine().split(", ");

        Function<String, Double> asDouble = Double::parseDouble;
        UnaryOperator<Double> addVat = e -> e * 1.2;
        Arrays.stream(realNumbers).map(asDouble)
                .map(addVat)
                .forEach(n -> System.out.printf("%.2f%n", n));
    }
}
