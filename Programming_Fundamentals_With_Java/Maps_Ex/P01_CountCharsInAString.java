package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().replaceAll(" ", "");

        Map<Character, Integer> productMap = new LinkedHashMap<>();

        for (char symbol : input.toCharArray()) {
            if (symbol == ' ') {
                continue;

            }
            if (!productMap.containsKey(symbol)) {
                productMap.put(symbol, 0);
            }
            productMap.put(symbol, productMap.get(symbol) + 1);


        }
        for (Map.Entry<Character, Integer> entry : productMap.entrySet()) {
            System.out.printf("%c -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}

