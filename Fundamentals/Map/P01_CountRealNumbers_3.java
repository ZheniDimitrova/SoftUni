package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01_CountRealNumbers_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        TreeMap<Integer, Integer> numbersMap = new TreeMap<>();

        for (int number : numArr) {
            numbersMap.putIfAbsent(number, 0);
            numbersMap.put(number, numbersMap.get(number) + 1);

        }
        for (Map.Entry<Integer, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%d -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}


