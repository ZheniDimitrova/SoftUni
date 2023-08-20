package fundamentalsSeptember2022_04Methods_LAB;

import java.util.Scanner;

public class P05_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        printPriceOrders(product, quantity);
    }

    public static void printPriceOrders(String product, int quantity) {
        double price = 0;
        switch (product) {
            case "coffee":
                price = quantity * 1.50;
                System.out.printf("%.2f", price);
                break;

            case "water":
                price = quantity * 1.00;
                System.out.printf("%.2f", price);
                break;

            case "coke":
                price = quantity * 1.40;
                System.out.printf("%.2f", price);
                break;

            case "snacks":
                price = quantity * 2.00;
                System.out.printf("%.2f", price);
                break;
        }
    }
}
