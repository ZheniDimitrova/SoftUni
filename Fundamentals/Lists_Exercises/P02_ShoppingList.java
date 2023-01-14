package fundamentalsSeptember2022_05Lists_Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P02_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> productsList = Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")) {
            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "Urgent":
                    String urgentItem = command[1];
                    if (!productsList.contains(urgentItem)) {
                        productsList.add(0, urgentItem);
                    }
                    break;

                case "Unnecessary":
                    String unnecessaryItem = command[1];
                    productsList.remove(unnecessaryItem);

                    break;

                case "Correct":
                    String oldItem = command[1];
                    String newItem = command[2];

                    if (productsList.contains(oldItem)) {
                        productsList.set(productsList.indexOf(oldItem), newItem);
                    }
                    break;

                case "Rearrange":
                    String item = command[1];

                    if (productsList.contains(item)) {
                        productsList.remove(item);
                        productsList.add(item);
                    }
                    break;

            }

            input = scanner.nextLine();
        }
        for (int i = 0; i < productsList.size(); i++) {
           String currentProduct = productsList.get(i);
            if (i != productsList.size() -1){
                System.out.print(currentProduct + ", ");
            } else{
                System.out.print(currentProduct);
            }
        }

    }

}

