package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01_CountRealNumbers_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        TreeMap<Integer, Integer> numMap = new TreeMap<>();

        for (int number: numbersArr){
            if (!numMap.containsKey(number)){
               numMap.put(number, 0);
            }
            numMap.put(number, numMap.get(number) +1);
        }
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            System.out.printf("%d -> %d%n",entry.getKey(), entry.getValue());
        }

    }
}
