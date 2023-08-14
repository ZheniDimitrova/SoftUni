package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.*;

public class P03_Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<Integer>> citiesMap = new LinkedHashMap<>();

        while (!input.equals("Sail")) {
            String[] citiesData = input.split("\\|\\|");
            String cityName = citiesData[0];
            int population = Integer.parseInt(citiesData[1]);
            int gold = Integer.parseInt(citiesData[2]);

            if (!citiesMap.containsKey(cityName)) {
                citiesMap.put(cityName, new ArrayList<>());
                citiesMap.get(cityName).add(population);
                citiesMap.get(cityName).add(gold);
            } else {
                citiesMap.get(cityName).set(0, citiesMap.get(cityName).get(0) + population);
                citiesMap.get(cityName).set(1, citiesMap.get(cityName).get(1) + gold);
            }


            input = scanner.nextLine();
        }

        String lineInput = scanner.nextLine();

        while (!lineInput.equals("End")) {
            String[] data = lineInput.split("=>");
            String event = data[0];
            String city = data[1];

            switch (event) {
                case "Plunder":
                    int people = Integer.parseInt(data[2]);
                    int goldToPlunder = Integer.parseInt(data[3]);

                    citiesMap.get(city).set(0, citiesMap.get(city).get(0) - people);
                    citiesMap.get(city).set(1, citiesMap.get(city).get(1) - goldToPlunder);

                    if (citiesMap.get(city).get(0) == 0 || citiesMap.get(city).get(1) == 0){

                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, goldToPlunder, people );
                        citiesMap.remove(city);
                        System.out.printf("%s has been wiped off the map!%n", city);

                    } else {
                        System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, goldToPlunder, people );
                    }

                    break;
                case "Prosper":
                    int goldToProsper = Integer.parseInt(data[2]);

                    if (goldToProsper < 0){
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        citiesMap.get(city).set(1, citiesMap.get(city).get(1) + goldToProsper);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", goldToProsper, city,citiesMap.get(city).get(1));
                    }

                    break;
            }

            lineInput = scanner.nextLine();
        }

        if (citiesMap.size() != 0){
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", citiesMap.size());
            for (Map.Entry<String, List<Integer>> entry : citiesMap.entrySet()) {
                String city = entry.getKey();
                int population = entry.getValue().get(0);
                int gold = entry.getValue().get(1);
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", city,population, gold);
            }
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }

    }
}
