package fundamentalsSeptember2022_02DataTypesAndVariables_Exercises;

import java.util.Scanner;

public class P09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberStartingYield = Integer.parseInt(scanner.nextLine());

        int workersConsume = 26;
        int days = 0;
        int sumSpices = 0;
        int totalSumSpices = 0;

        while (numberStartingYield >= 100) {
            int extractSpices = numberStartingYield - workersConsume;
            sumSpices += extractSpices;
            numberStartingYield -= 10;
            days++;
            if (extractSpices >= workersConsume) {
                totalSumSpices = sumSpices - workersConsume;
            }

        }
        System.out.println(days);
        System.out.println(totalSumSpices);
    }

}
