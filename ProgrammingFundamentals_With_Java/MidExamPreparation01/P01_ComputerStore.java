package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.Scanner;

public class P01_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double totalSumNoTaxes = 0;


        while (!input.equals("special") && !input.equals("regular")) {

            double currentPrice = Double.parseDouble(input);

            if (currentPrice < 0) {
                System.out.println("Invalid price!");
                input = scanner.nextLine();
                continue;
            }

            totalSumNoTaxes += currentPrice;

            input = scanner.nextLine();
        }
        double taxes = totalSumNoTaxes * 0.2;
        if ((totalSumNoTaxes + taxes) == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalSumNoTaxes);
            System.out.printf("Taxes: %.2f$%n", taxes);
            System.out.println("-----------");


            if (input.equals("special")) {
                System.out.printf("Total price: %.2f$", (totalSumNoTaxes + taxes) * 0.9);
            } else {
                System.out.printf("Total price: %.2f$", totalSumNoTaxes + taxes);
            }
        }

    }
}
