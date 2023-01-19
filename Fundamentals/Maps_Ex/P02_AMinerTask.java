package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String resource = scanner.nextLine();
        Map<String, Integer> resourceMap = new LinkedHashMap<>();

        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourceMap.containsKey(resource)) {
                resourceMap.put(resource, quantity);
            } else {
                int sumQuantity = resourceMap.get(resource) + quantity;
                resourceMap.put(resource, sumQuantity);
            }
            resource = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : resourceMap.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(),entry.getValue());
        }
    }
}
