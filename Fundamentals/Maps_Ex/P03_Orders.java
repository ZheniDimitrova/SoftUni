package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Double> priceMap = new LinkedHashMap<>();
        Map<String, Integer> quantityMap = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String[] productData = input.split(" ");
            String productName = productData[0];
            double productPrice = Double.parseDouble(productData[1]);
            int quantity = Integer.parseInt(productData[2]);

            priceMap.put(productName, productPrice);

            if (!quantityMap.containsKey(productName)) {
                quantityMap.put(productName, quantity);
            } else {
                quantityMap.put(productName, quantityMap.get(productName) + quantity);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Double> entry : priceMap.entrySet()) {
            String name = entry.getKey();
            double totalPrice = entry.getValue() * quantityMap.get(name);

            System.out.printf("%s -> %.2f%n", name, totalPrice);
        }
    }
}
