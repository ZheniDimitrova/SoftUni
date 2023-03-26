package advansedJanuary2023_05LAB_FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class p04_addVAT_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        List<Double> addVatList = new ArrayList<>();

        for (String realNum : input) {
            addVatList.add(Double.parseDouble(realNum));

        }
        UnaryOperator<Double> addVat = n -> n * 1.2;
        System.out.println("Prices with VAT:");
        for (Double str : addVatList) {
            System.out.println(String.format("%1$.2f", addVat.apply(str)));
        }
    }
}
