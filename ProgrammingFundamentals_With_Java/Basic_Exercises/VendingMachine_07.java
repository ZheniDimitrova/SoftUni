package fundamentalsSeptember2022_01Basic_Exercises;

import java.util.Scanner;

public class VendingMachine_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        double sum = 0;

        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);
            if (coins == 0.1 || coins == 0.2 || coins == 0.5 || coins == 1 || coins == 2) {
                sum += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);
            }
            input = scanner.nextLine();
        }

        String product = scanner.nextLine();
        double price = 0;

        while (!product.equals("End")) {
            switch (product) {
                case "Nuts":
                    price = 2.0;
                    break;
                case "Water":
                    price = 0.7;
                    break;
                case "Crisps":
                    price = 1.5;
                    break;
                case "Soda":
                    price = 0.8;
                    break;
                case "Coke":
                    price = 1.0;
                    break;

            }
            if (!product.equals("Nuts") && !product.equals("Water") && !product.equals("Crisps") && !product.equals("Soda") && !product.equals("Coke")) {
                System.out.println("Invalid product");
            } else if (sum < price) {
                System.out.println("Sorry, not enough money");
            } else {
                System.out.printf("Purchased %s%n", product);
                sum -= price;
            }

            product = scanner.nextLine();
        }

        System.out.printf("Change: %.2f", sum);
    }

}

