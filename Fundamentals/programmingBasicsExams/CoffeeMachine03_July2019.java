package programmingBasicsExams;

import com.sun.source.tree.IfTree;

import java.util.Scanner;

public class CoffeeMachine03_July2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String drink = scanner.nextLine();
        String sugar = scanner.nextLine();
        int numberOfDrinks = Integer.parseInt(scanner.nextLine());
        double drinkPrice = 0;

        switch (drink) {
            case "Espresso":
                switch (sugar){
                    case "Without":
                        drinkPrice = 0.90;
                        break;
                    case "Normal":
                        drinkPrice = 1.00;
                        break;
                    case "Extra":
                        drinkPrice = 1.20;
                        break;
                }
                break;

            case "Cappuccino":
                switch (sugar){
                    case "Without":
                        drinkPrice = 1.00;
                        break;
                    case "Normal":
                        drinkPrice = 1.20;
                        break;
                    case "Extra":
                        drinkPrice = 1.60;
                        break;
                }
                break;

            case "Tea":
                switch (sugar){
                    case "Without":
                        drinkPrice = 0.50;
                        break;
                    case "Normal":
                        drinkPrice = 0.60;
                        break;
                    case "Extra":
                        drinkPrice = 0.70;
                        break;
                }
                break;
        }
        if (sugar.equals("Without")){
            drinkPrice = drinkPrice - (drinkPrice * 0.35);
        }
        if (drink.equals("Espresso") && numberOfDrinks >= 5){
            drinkPrice = drinkPrice - (drinkPrice * 0.25);
        }
        double totalDrinkPrice = numberOfDrinks * drinkPrice;

        if (totalDrinkPrice > 15){
            totalDrinkPrice = totalDrinkPrice - (totalDrinkPrice * 0.20);
        }
        System.out.printf("You bought %d cups of %s for %.2f lv.", numberOfDrinks, drink, totalDrinkPrice);
    }

}
