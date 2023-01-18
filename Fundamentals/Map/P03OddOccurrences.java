package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI;

import java.util.*;

public class P03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String line = scanner.nextLine().toLowerCase();
        String[] input = line.split(" ");

        Map<String, Integer> wordsMap = new LinkedHashMap<>();

        for (String word : input) {
            wordsMap.putIfAbsent(word, 0);
            wordsMap.put(word, wordsMap.get(word) + 1);
        }
        List<String> productList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                productList.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", productList));

    }
}

