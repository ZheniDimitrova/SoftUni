package advancedJanuary2023_03Ex_SetsAndMaps;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class p03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Set<String> periodicTableSet = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] inputElements = scanner.nextLine().split("\\s+");
            periodicTableSet.addAll(Arrays.asList(inputElements));

        }
        for (String element : periodicTableSet){
            System.out.print(element + " ");
        }
    }
}
