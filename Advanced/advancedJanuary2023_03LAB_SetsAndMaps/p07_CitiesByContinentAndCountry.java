package advancedJanuary2023_03LAB_SetsAndMaps;

import java.util.*;

public class p07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> worldMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String continent = info[0];
            String country = info[1];
            String city = info[2];

            if (!worldMap.containsKey(continent)) {
                worldMap.put(continent, new LinkedHashMap<>());
            }

            if (!worldMap.get(continent).containsKey(country)) {
                worldMap.get(continent).put(country, new ArrayList<>());
            }
            worldMap.get(continent).get(country).add(city);

        }
        for (Map.Entry<String, Map<String, List<String>>> entry : worldMap.entrySet()) {
            String continent = entry.getKey();
            System.out.println(continent + ":");

            for (Map.Entry<String, List<String>> doubleEntry : worldMap.get(continent).entrySet()) {
                String country = doubleEntry.getKey();
                System.out.print(country + " -> ");
                System.out.print(String.join(", ", doubleEntry.getValue()));

                System.out.println();

            }

        }

    }
}
