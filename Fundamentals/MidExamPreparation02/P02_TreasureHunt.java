package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.*;
import java.util.stream.Collectors;

public class P02_TreasureHunt {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<String> treasureChest = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String commandInput = scanner.nextLine();

        while (!commandInput.equals("Yohoho!")) {
            String[] command = commandInput.split(" ");

            switch (command[0]) {
                case "Loot":
                    for (int i = 1; i <= command.length - 1; i++) {
                        String item = command[i];
                        if (!treasureChest.contains(item)) {
                            treasureChest.add(0, item);
                        }
                    }
                    break;

                case "Drop":
                    int indexToDrop = Integer.parseInt(command[1]);
                    if (indexToDrop < 0 || indexToDrop > treasureChest.size() - 1) {
                        break;
                    }
                    treasureChest.add(treasureChest.remove(indexToDrop));

                    break;

                case "Steal":
                    List<String> stolenItems = new ArrayList<>();
                    int countItems = Integer.parseInt(command[1]);

                    if(countItems > treasureChest.size()){
                        System.out.println(String.join(", ", treasureChest));
                        treasureChest.clear();
                        break;
                    }

                    for (int i = 0; i < countItems; i++) {
                        int lastIndex = treasureChest.size() - 1;
                        stolenItems.add(0, treasureChest.remove(lastIndex));
                    }
                    System.out.println(String.join(", ", stolenItems));

                    break;
            }

            commandInput = scanner.nextLine();

        }
        double sumItems = 0;

        for (int i = 0; i < treasureChest.size(); i++) {
            String currentItem = treasureChest.get(i);
            sumItems += currentItem.length();
        }
        double average = sumItems / treasureChest.size();

        if (treasureChest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", average);
        }

    }

}

