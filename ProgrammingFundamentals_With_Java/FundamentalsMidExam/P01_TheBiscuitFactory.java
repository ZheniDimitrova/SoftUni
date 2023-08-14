package fundamentalsSeptember2022_MidExam_Oct23;

import java.util.Scanner;

public class P01_TheBiscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int biscuitPerDayPerWorker =Integer.parseInt(scanner.nextLine());
        int workersCount = Integer.parseInt(scanner.nextLine());
        int biscuitsOfOtherFactory = Integer.parseInt(scanner.nextLine());

        double sumMonthPerWorker = 0;
        double totalBiscuits = 0;

        double sumPerDayAllWorkers = biscuitPerDayPerWorker * workersCount;

        for (int day = 1; day <= 30 ; day++) {
            if (day % 3 == 0){
                totalBiscuits += Math.floor(sumPerDayAllWorkers * 0.75);
            } else{
                totalBiscuits += sumPerDayAllWorkers;
            }
        }

            System.out.printf("You have produced %.0f biscuits for the past month.%n", totalBiscuits);
        if (totalBiscuits > biscuitsOfOtherFactory){
            System.out.printf("You produce %.2f percent more biscuits.%n", (totalBiscuits / biscuitsOfOtherFactory *100) - 100);
        } else {
            System.out.printf("You produce %.2f percent less biscuits.", ((biscuitsOfOtherFactory - totalBiscuits) / biscuitsOfOtherFactory) * 100);
        }

    }
}
