package fundamentalsSeptember2022_FinalExam_Preparation;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> plantsRarityMap = new LinkedHashMap<>();

        Map<String, Double> plantRatingMap =new LinkedHashMap<>();


        for (int i = 1; i <= n; i++) {
            String[] plantInfoArr = scanner.nextLine().split("<->");
            String plant = plantInfoArr[0];
            int rarity = Integer.parseInt(plantInfoArr[1]);

            plantRatingMap.put(plant, 0.0);
            plantsRarityMap.put(plant, rarity);

        }

        String input = scanner.nextLine();

        while (!input.equals("Exhibition")) {
            String[] commandsArr = input.split("[: -]+");
            String command = commandsArr[0];
            String plant = commandsArr[1];


            if (!plantsRarityMap.containsKey(plant)) {
                System.out.println("error");
            } else {
                switch (command) {
                    case "Rate":
                        double rating = Double.parseDouble(commandsArr[2]);
                        if(plantRatingMap.get(plant) == 0){
                            plantRatingMap.put(plant, rating);
                        } else {
                            double newRating = (plantRatingMap.get(plant) + rating) / 2;
                            plantRatingMap.put(plant, newRating);
                        }
                    break;

                    case "Update":
                        int newRarity = Integer.parseInt(commandsArr[2]);
                        plantsRarityMap.put(plant, newRarity);
                    break;

                    case "Reset":
                        plantRatingMap.put(plant, 0.0);
                    break;

                }
            }

            input = scanner.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        for (Map.Entry<String, Integer> entry : plantsRarityMap.entrySet()) {
            System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(), plantRatingMap.get(entry.getKey()));
        }

    }
}
