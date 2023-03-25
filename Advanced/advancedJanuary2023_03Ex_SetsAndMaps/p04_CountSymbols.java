package advancedJanuary2023_03Ex_SetsAndMaps;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> charsMap = new TreeMap<>();

        for (char element : input.toCharArray()) {
            if (!charsMap.containsKey(element)) {
                charsMap.put(element, 1);
            } else {
                charsMap.put(element, charsMap.get(element) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : charsMap.entrySet()) {
            System.out.println(entry.getKey() + ":" + " " + entry.getValue() + " " + "time/s");
        }

    }
}
