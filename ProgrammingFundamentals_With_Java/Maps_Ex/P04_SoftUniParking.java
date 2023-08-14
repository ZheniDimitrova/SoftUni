package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI_Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> userData = new LinkedHashMap<>();

        for (int command = 1; command <= n; command++) {
            String[] inputCommand = scanner.nextLine().split(" ");

            String typeCommand = inputCommand[0];
            String username = inputCommand[1];

            if (typeCommand.equals("register")) {
                String plateNumber = inputCommand[2];

                if (!userData.containsKey(username)) {
                    userData.put(username, plateNumber);
                    System.out.printf("%s registered %s successfully%n", username, plateNumber);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", plateNumber);
                }

            } else if (typeCommand.equals("unregister")) {

                if (!userData.containsKey(username)) {
                    System.out.printf("ERROR: user %s not found%n", username);
                } else {
                    userData.remove(username);
                    System.out.printf("%s unregistered successfully%n", username);
                }
            }
        }
        for (Map.Entry<String, String> entry : userData.entrySet()) {
            System.out.printf("%s => %s%n", entry.getKey(), entry.getValue());
        }
    }
}
