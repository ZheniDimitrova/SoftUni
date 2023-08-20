package fundamentalsSeptember2022_MidExam_Preparation;

import com.sun.source.tree.IfTree;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_Inventory2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventoryItems = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("Craft!")) {
            String[] command = inputCommand.split(" - ");

            switch (command[0]) {
                case "Collect":
                    String collectItem = command[1];
                    if (!inventoryItems.contains(collectItem)) {
                        inventoryItems.add(collectItem);
                    }
                    break;

                case "Drop":
                    String dropItem = command[1];
                    inventoryItems.remove(dropItem);
                    break;

                case "Combine Items":
                    String[] itemsToCombine = command[1].split("\\:");
                    String oldItem = itemsToCombine[0];
                    String newItem = itemsToCombine[1];
                    if (inventoryItems.contains(oldItem)) {
                        inventoryItems.add(inventoryItems.indexOf(oldItem) + 1, newItem);
                    }
                    break;

                case "Renew":
                    String renewItem = command[1];
                    if (inventoryItems.contains(renewItem)){
                        inventoryItems.remove(renewItem);
                        inventoryItems.add(renewItem);
                    }
                    break;
            }


            inputCommand = scanner.nextLine();
        }
        System.out.println(String.join(", ", inventoryItems));
    }
}
