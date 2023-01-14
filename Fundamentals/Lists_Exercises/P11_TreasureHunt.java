package fundamentalsSeptember2022_05Lists_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P11_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasureChest = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Yohoho!")) {
            List<String> commandItems =Arrays.stream(input.split(" ")).collect(Collectors.toList());
            if (commandItems.contains("Loot")){
                for( String commandElem: commandItems){
                    for(String chestElem: treasureChest){
                        if (!treasureChest.contains(commandElem)) {
                            treasureChest.add(0, commandElem);
                            break;
                        }
                        }
                    }
                }
            }
        System.out.println(treasureChest);













//            switch (commandItems[0]) {
//                case "Loot":
//                    for (int i = 1; i <= commandItems.length ; i++) {
//                        for (int j = 1; j <= treasureChest.size() ; j++) {
//
//                        }
//
//                    }
//                    break;
//
//                case "Drop":
//                    break;
//
//                case "Steal":
//                    break;
            }

        }


