package programmingBasicsExams;

import java.util.Scanner;

public class PoolDay01_July2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        double enter = Double.parseDouble(scanner.nextLine());
        double sunLoungerPrice = Double.parseDouble(scanner.nextLine());
        double umbrellaPrice = Double.parseDouble(scanner.nextLine());

        double enterFee = people * enter;
        double umbrella = (Math.ceil(people * 0.5) * umbrellaPrice);
        double sunLounger = (Math.ceil(people * 0.75) * sunLoungerPrice);

        System.out.printf("%.2f lv.", enterFee + umbrella + sunLounger);
    }
}
