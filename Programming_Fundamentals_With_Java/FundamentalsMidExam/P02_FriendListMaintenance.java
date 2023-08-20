package fundamentalsSeptember2022_MidExam_Oct23;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_FriendListMaintenance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> namesList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();
        int blackListedCount = 0;
        int listedCount = 0;



        while (!input.equals("Report")) {
            String[] command = input.split(" ");

            switch (command[0]) {
                case "Blacklist":
                    String blacklistedName = command[1];

                    if (namesList.contains(blacklistedName)){
                        namesList.set(namesList.indexOf(blacklistedName), "Blacklisted");
                        blackListedCount++;
                        System.out.printf("%s was blacklisted.%n", blacklistedName);
                    } else{
                        System.out.printf("%s was not found.%n", blacklistedName);
                    }
                    break;

                case "Error":
                    int index = Integer.parseInt(command[1]);
                    if (index < 0 || index >= namesList.size()){
                        break;
                    }
                    String errorName = namesList.get(index);

                    if(!errorName.equals("Blacklisted") && !errorName.equals("Lost")){
                        namesList.set(namesList.indexOf(errorName),"Lost" );
                        listedCount++;
                        System.out.printf("%s was lost due to an error.%n", errorName);
                    }
                    break;

                case "Change":
                    int indexToChange = Integer.parseInt(command[1]);
                    String newName = command[2];

                    if (indexToChange < 0 || indexToChange >= namesList.size()){
                        break;
                    } else{
                        String oldName = namesList.get(indexToChange);
                       namesList.set(namesList.indexOf(oldName), newName);
                       System.out.printf("%s changed his username to %s.%n", oldName, newName );

                    }
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.printf("Blacklisted names: %d%n", blackListedCount);
        System.out.printf("Lost names: %d%n", listedCount);

        for (String name : namesList){
            System.out.print(name + " ");
        }
    }
}
