package advancedJanuary2023_03Ex_SetsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class p05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, String> phonebookMap = new HashMap<>();

        while (!input.equals("search")) {
            String[] info = input.split("-");
            String name = info[0];
            String number = info[1];

            phonebookMap.put(name, number);

            input = scanner.nextLine();
        }

        String searchedName = scanner.nextLine();

        while (!searchedName.equals("stop")) {
            if (phonebookMap.containsKey(searchedName)) {
                System.out.printf("%s -> %s%n", searchedName, phonebookMap.get(searchedName));
            }else{
                System.out.printf("Contact %s does not exist.%n", searchedName);
            }

            searchedName = scanner.nextLine();
        }

    }
}

