package programmingBasicsExams;

import java.util.Scanner;

public class GodzillaVsKong02_April2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double filmBudget = Double.parseDouble(scanner.nextLine());
        int statists = Integer.parseInt(scanner.nextLine());
        double costumePrice = Double.parseDouble(scanner.nextLine());

        double decor = filmBudget * 0.1;
        double allStstistsCostumePrice = statists * costumePrice;
        if (statists > 150){
           allStstistsCostumePrice = allStstistsCostumePrice - (allStstistsCostumePrice * 0.1);
        }

            double filmPrice = decor + allStstistsCostumePrice;

            if (filmPrice > filmBudget){
                System.out.println("Not enough money!");
                System.out.printf("Wingard needs %.2f leva more.", filmPrice - filmBudget);
            }
            if (filmPrice <= filmBudget){
                System.out.println("Action!");
                System.out.printf("Wingard starts filming with %.2f leva left.", filmBudget - filmPrice);
            }
        }
    }
