package fundamentalsSeptember2022_01Basic_Exercises;

import java.util.Scanner;

public class Orders_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ordersCount = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;

        for (int i = 1; i <= ordersCount ; i++) {
            double priceForCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());

            double oneOrderPrice = (days * capsulesCount) * priceForCapsule;
            System.out.printf("The price for the coffee is: $%.2f%n", oneOrderPrice);
            totalPrice += oneOrderPrice;
        }

            System.out.printf("Total: $%.2f", totalPrice);
    }
}
