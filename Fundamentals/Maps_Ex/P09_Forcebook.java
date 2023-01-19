package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI_Exercises;

import java.util.*;

public class P09_Forcebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Map<String, List<String>> dataMap = new LinkedHashMap<>();

        while (!command.equals("Lumpawaroo")) {
            if (command.contains(" | ")) {
                String forceSide = command.split("\\s+\\|\\s+")[0];
                String forceUser = command.split("\\s+\\|\\s+")[1];

                if (!dataMap.containsKey(forceSide)) {
                    dataMap.put(forceSide, new ArrayList<>());
                }

                boolean isExist = false;
                for (List<String> usersList : dataMap.values()) {
                    if (usersList.contains(forceUser)) {
                        isExist = true;
                        break;
                    }
                }
                if (!isExist) {
                    dataMap.get(forceSide).add(forceUser);
                }

            } else if (command.contains(" -> ")) {
                String forceUser = command.split("\\s+->\\s+")[0];
                String forceSide = command.split("\\s+->\\s+")[1];

                dataMap.entrySet().forEach(entry -> entry.getValue().remove(forceUser));
                if (dataMap.containsKey(forceSide)) {
                    dataMap.get(forceSide).add(forceUser);
                } else {
                    dataMap.put(forceSide, new ArrayList<>());
                    dataMap.get(forceSide).add(forceUser);
                }
                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
            }

            command = scanner.nextLine();
        }
        dataMap.entrySet().stream().filter(entry -> entry.getValue().size() > 0)
                .forEach(entry -> {
                    System.out.printf("Side: %s, Members: %d%n", entry.getKey(), entry.getValue().size());
                    entry.getValue().forEach(user -> System.out.println("! " + user));

                });
    }


}
