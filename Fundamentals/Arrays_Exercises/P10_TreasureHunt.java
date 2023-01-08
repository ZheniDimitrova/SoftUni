package fundamentalsSeptember2022_03Arrays_Exercises;

import nestedLoops.SumOfTwoNumbers04;

import java.util.Scanner;

public class P10_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] chestWithTreasure = scanner.nextLine().split("\\|");

        String command = scanner.nextLine();

        while (!command.equals("Yohoho!")) {
            String[] commandTreasureParts = command.split(" ");

            if (command.startsWith("Loot")) {
                int counterEqualsElem = 0;
                for (int treasureIndex = 1; treasureIndex <= commandTreasureParts.length - 1; treasureIndex++) {
                    for (int index = 0; index < chestWithTreasure.length; index++) {
                        if (chestWithTreasure[index].equals(commandTreasureParts[treasureIndex])) {
                            commandTreasureParts[treasureIndex] = "";
                            counterEqualsElem++;
                        }
                    }
                }
                String[] newTreasure = new String[(chestWithTreasure.length + commandTreasureParts.length - 1) - counterEqualsElem];
                int newTreasureIndex = 0;
                for (int index = 0; index < commandTreasureParts.length; index++) {
                    if (!commandTreasureParts[index].equals("")) {
                        newTreasure[newTreasureIndex] = commandTreasureParts[index];
                        newTreasureIndex++;
                    }
                }
                for (int index = 0; index < chestWithTreasure.length; index++) {
                    if(newTreasureIndex >= newTreasure.length){
                        break;
                    }
                    newTreasure[newTreasureIndex] = chestWithTreasure[index];
                    newTreasureIndex++;
                }
                chestWithTreasure = newTreasure;

            } else if (command.startsWith("Drop")) {
                int commandIndex = Integer.parseInt(commandTreasureParts[1]);
                if (commandIndex > chestWithTreasure.length - 1 || commandIndex < 0) {
                    command = scanner.nextLine();
                    continue;
                }
                String originalElement = chestWithTreasure[commandIndex];

                for (int index = commandIndex; index <= chestWithTreasure.length - 2; index++) {
                    chestWithTreasure[index] = chestWithTreasure[index + 1];
                }
                chestWithTreasure[chestWithTreasure.length - 1] = originalElement;
            } else if (command.startsWith("Steal")) {
                int commandCount = Integer.parseInt(commandTreasureParts[1]);
                if (commandCount > chestWithTreasure.length) {
                    System.out.println(String.join(" ", chestWithTreasure));
                    chestWithTreasure = new String[]{};
                } else {
                    for (int index = chestWithTreasure.length - commandCount; index <= chestWithTreasure.length - 1; index++) {
                        System.out.print(chestWithTreasure[index] + " ");
                    }
                    String[] newChest = new String[chestWithTreasure.length - commandCount];
                    for (int index = 0; index <= chestWithTreasure.length - 1 - commandCount; index++) {
                        newChest[index] = chestWithTreasure[index];
                        chestWithTreasure = newChest;

                    }

                }
            }
            command = scanner.nextLine();
        }
        if (chestWithTreasure.length == 0) {
            System.out.println("Failed treasure hunt.");
            return;
        }
        double sum = 0;
        for (String element : chestWithTreasure) {
            sum += element.length();
        }
        System.out.printf("%.2f", sum / chestWithTreasure.length);

    }

}

