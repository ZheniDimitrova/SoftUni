package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.Scanner;

public class P01_BlackFlag {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfPlunder = Integer.parseInt(scanner.nextLine());
        int dailyPlunder = Integer.parseInt(scanner.nextLine());
        int expectedPlunder = Integer.parseInt(scanner.nextLine());


        double sumOfPlunder = 0;
        for (int day = 1; day <= daysOfPlunder; day++) {
            sumOfPlunder += dailyPlunder;

            if (day % 3 == 0){
                sumOfPlunder += dailyPlunder * 0.5;
            }
            if (day % 5 == 0){
                sumOfPlunder = sumOfPlunder  - sumOfPlunder * 0.3;
            }
        }
        if (sumOfPlunder >= expectedPlunder){
            System.out.printf("Ahoy! %.2f plunder gained.", sumOfPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", sumOfPlunder / expectedPlunder *100);
        }
    }
}
