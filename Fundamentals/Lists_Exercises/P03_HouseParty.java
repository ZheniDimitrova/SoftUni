package fundamentalsSeptember2022_05Lists_Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        List<String> namesList = new ArrayList<>();


        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String inputName = command[0];

            if (!command[2].equals("not")) {

                if (!namesList.contains(inputName)) {
                    namesList.add(inputName);
                } else {
                    System.out.printf("%s is already in the list!%n", inputName);
                }
            } else {
                if (namesList.contains(inputName)) {
                    namesList.remove(inputName);
                } else {
                    System.out.printf("%s is not in the list!%n", inputName);
                }
            }
        }

        for (String names : namesList) {
            System.out.println(names);
        }
    }
}
