package advancedJanuary2023_03Ex_SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int first = Integer.parseInt(input[0]);
        int second = Integer.parseInt(input[1]);

        Set<Integer> firstSet = new LinkedHashSet<>();
        Set<Integer> secondSet = new LinkedHashSet<>();

        for (int i = 0; i < first; i++) {
            firstSet.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < second; i++) {
            secondSet.add(Integer.parseInt(scanner.nextLine()));
        }

        firstSet.retainAll(secondSet);

        for (int num : firstSet) {
            System.out.print(num + " ");
        }

    }
}
