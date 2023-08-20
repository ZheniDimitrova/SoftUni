package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI_Exercises;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10_SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> usersAndPointsMap = new LinkedHashMap<>();
        Map<String, Integer> languageCountMap = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("exam finished")) {
            String[] commandsArr = input.split("-");

            String username = commandsArr[0];

            if (commandsArr.length == 3) {
                String language = commandsArr[1];
                int points = Integer.parseInt(commandsArr[2]);

                if (!usersAndPointsMap.containsKey(username)) {
                    usersAndPointsMap.put(username, points);
                } else {
                    int currentPoints = usersAndPointsMap.get(username);
                    if (currentPoints < points) {
                        usersAndPointsMap.put(username, points);
                    }
                }
                if (!languageCountMap.containsKey(language)){
                    languageCountMap.put(language, 1);
                } else{
                    languageCountMap.put(language, languageCountMap.get(language) + 1);
                }

            } else {
                usersAndPointsMap.remove(username);
            }
            input = scanner.nextLine();
        }
        System.out.println("Results:");
        for (Map.Entry<String, Integer> entry : usersAndPointsMap.entrySet()) {
            System.out.printf("%s | %d%n", entry.getKey(), entry.getValue());
        }
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : languageCountMap.entrySet()) {
            System.out.printf("%s - %d%n", entry.getKey(), entry.getValue());
        }


    }
}

