package programmingBasicsExams;

import java.util.Scanner;

public class Club04_July019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double desiredMoney = Double.parseDouble(scanner.nextLine());
        String inputCocktailName = scanner.nextLine();
        double sumOrders = 0;


        while (!inputCocktailName.equals("Party!")) {
            int numberCocktails = Integer.parseInt(scanner.nextLine());

            double cocktailPrice = inputCocktailName.length();
            double totalCocktailPrice = numberCocktails * cocktailPrice;
            if (totalCocktailPrice % 2 != 0) {
                totalCocktailPrice = totalCocktailPrice - (totalCocktailPrice * 0.25);

            }
            sumOrders += totalCocktailPrice;
            if (sumOrders >= desiredMoney){
                System.out.println("Target acquired.");
                System.out.printf("Club income - %.2f leva.", sumOrders);
                break;
            }
            inputCocktailName = scanner.nextLine();
        }
        if (inputCocktailName.equals("Party!")){
            System.out.printf("We need %.2f leva more.%n", desiredMoney - sumOrders);
            System.out.printf("Club income - %.2f leva.", sumOrders);
        }

        }
    }

