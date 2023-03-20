package advancedJanuary2023_03LAB_SetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class p06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> productsMap = new TreeMap<>();

        String input = scanner.nextLine();

        while(!input.equals("Revision")){
            String[] info = input.split(", ");
            String shopName = info[0];
            String product = info[1];
            double price = Double.parseDouble(info[2]);

            if (!productsMap.containsKey(shopName)){
                productsMap.put(shopName, new LinkedHashMap<>());
            }
               if (!productsMap.get(shopName).containsKey(product)){
                   productsMap.get(shopName).put(product, price);
               }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Double>> entry : productsMap.entrySet()) {
             String shop = entry.getKey();
            System.out.println(shop + "->");

            for (Map.Entry<String, Double> doubleEntry : productsMap.get(shop).entrySet()) {
                String product = doubleEntry.getKey();
                double price = doubleEntry.getValue();
                System.out.printf("Product: %s, Price: %.1f%n", product, price);
            }

        }

    }
}
