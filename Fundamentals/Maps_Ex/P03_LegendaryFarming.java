package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> itemsMap = new LinkedHashMap<>();
        itemsMap.put("shards", 0);
        itemsMap.put("fragments", 0);
        itemsMap.put("motes", 0);

        Map<String, Integer> junksMap = new LinkedHashMap<>();
        boolean isWin = false;

        while (!isWin) {
            String line = scanner.nextLine();
            String[] input = line.split(" ");

            for (int i = 0; i <= input.length - 1; i += 2) {
                int quantity = Integer.parseInt(input[i]);
                String material = input[i + 1].toLowerCase();

                if (material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                    itemsMap.put(material, itemsMap.get(material) + quantity);
                } else {
                    if (!junksMap.containsKey(material)) {
                        junksMap.put(material, quantity);
                    } else {
                        junksMap.put(material, junksMap.get(material) + quantity);

                    }
                }
                if (itemsMap.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    itemsMap.put("shards", itemsMap.get("shards") - 250);
                    isWin = true;
                    break;
                } else if (itemsMap.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    itemsMap.put("fragments", itemsMap.get("fragments") - 250);
                    isWin = true;
                    break;
                } else if (itemsMap.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    itemsMap.put("motes", itemsMap.get("motes") - 250);
                    isWin = true;
                    break;
                }
            }
            if (isWin) {
                break;
            }

        }
        for (Map.Entry<String, Integer> entry : itemsMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
        for (Map.Entry<String, Integer> entry : junksMap.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }

}


