package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> collectingItems = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Craft!")) {
            String[] command = input.split(" - ");

            switch (command[0]) {
                case "Collect":
                    String itemToCollect = command[1];
                    if (!collectingItems.contains(itemToCollect)) {
                        collectingItems.add(itemToCollect);
                    }
                    break;

                case "Drop":
                    String itemToDrop = command[1];
                    if (collectingItems.contains(itemToDrop)) {
                        collectingItems.remove(itemToDrop);
                    }
                    break;

                case "Combine Items":
                    String[] oldNewItems = command[1].split("\\:");
                    String oldItem = oldNewItems[0];
                    String newItem = oldNewItems[1];

                    if (collectingItems.contains(oldItem)) {
                        collectingItems.add(collectingItems.indexOf(oldItem) + 1, newItem);
                    }

                    break;

                case "Renew":
                    String itemToRenew = command[1];
                    if (collectingItems.contains(itemToRenew)) {
                        collectingItems.remove(itemToRenew);
                        collectingItems.add(itemToRenew);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < collectingItems.size(); i++) {
            String currentItem = collectingItems.get(i);
            if (i < collectingItems.size() - 1) {
                System.out.print(currentItem + ", ");
            } else {
                System.out.print(currentItem);
            }

        }

    }

}

