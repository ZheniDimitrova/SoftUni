package fundamentalsSeptember2022_01Basic_LAB;

import java.util.Scanner;

public class TheatrePromotions_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeOfDay = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        double price = 0;
        boolean isValid = true;

        if (age >= 0 && age <= 18) {
            switch (typeOfDay) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 5;
                    break;
                default: isValid = false;
            }

        } else if (age > 18 && age <= 64) {
            switch (typeOfDay) {
                case "Weekday":
                    price = 18;
                    break;
                case "Weekend":
                    price = 20;
                    break;
                case "Holiday":
                    price = 12;
                    break;
                default: isValid = false;
            }

        } else if (age > 64 && age <= 122) {
            switch (typeOfDay) {
                case "Weekday":
                    price = 12;
                    break;
                case "Weekend":
                    price = 15;
                    break;
                case "Holiday":
                    price = 10;
                    break;
                default: isValid = false;
            }

        } else {
            isValid = false;
        }

        if (!isValid) {
            System.out.println("Error!");
        } else {
            System.out.printf("%.0f$", price);
        }


    }
}
