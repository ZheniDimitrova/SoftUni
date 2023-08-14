package advancedJanuary2023_03Ex_SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p01_UniqueUsername {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Set<String> wordsSet = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            wordsSet.add(input);
        }
        for (String word : wordsSet) {
            System.out.println(word);
        }
    }
}
