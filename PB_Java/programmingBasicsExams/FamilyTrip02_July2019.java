package programmingBasicsExams;

import java.util.Scanner;

public class FamilyTrip02_July2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double nightPrice = Double.parseDouble(scanner.nextLine());
        int additionalCostsPercent = Integer.parseInt(scanner.nextLine());

        if (nights > 7) {
            nightPrice = nightPrice - (nightPrice * 0.05);
        }
        double totalNightsPrice = nights * nightPrice;
        double additionalCostsSum = budget * (additionalCostsPercent * 1.0 / 100);
        double totalSum = totalNightsPrice + additionalCostsSum;

        if (totalSum <= budget) {
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", budget - totalSum);
        } else {
            System.out.printf("%.2f leva needed.", totalSum - budget);
        }
    }
}

