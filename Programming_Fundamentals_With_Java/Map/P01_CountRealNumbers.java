package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P01_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .mapToDouble(Double::parseDouble)
                        .toArray();
        TreeMap<Double, Integer> numbersMap = new TreeMap<>();

        for (double num : numbers){
            if (!numbersMap.containsKey(num)){
                numbersMap.put(num, 1);
            } else{
                numbersMap.put(num, numbersMap.get(num) + 1);
            }
        }
        for (Map.Entry<Double, Integer> entry : numbersMap.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
