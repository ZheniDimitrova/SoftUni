package advancedJanuary2023_03LAB_SetsAndMaps;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> sortedNumbers = Arrays.stream(scanner.nextLine().
                        split("\\s+")).
                map(Integer::parseInt).sorted((e1, e2) -> e2.compareTo(e1)).
                collect(Collectors.toList());

        for (int i = 0; i < 3 && i < sortedNumbers.size(); i++) {
            System.out.print(sortedNumbers.get(i) + " ");
        }

    }
}

