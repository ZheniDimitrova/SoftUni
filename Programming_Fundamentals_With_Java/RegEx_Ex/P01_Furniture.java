package fundamentalsSeptember2022_09RegularExpressions_Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<String> furnitureList = new ArrayList<>();
        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>[0-9]+\\.?[0-9]*)!(?<quantity>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        double totalPrice = 0;

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String furName = matcher.group("furnitureName");
                furnitureList.add(furName);

                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));

                double result = price * quantity;
                totalPrice += result;

            }

            input = scanner.nextLine();
        }

            System.out.println("Bought furniture:");
            for (String product : furnitureList) {
            System.out.println(product);
            }
        System.out.printf("Total money spend: %.2f", totalPrice);

    }
}
