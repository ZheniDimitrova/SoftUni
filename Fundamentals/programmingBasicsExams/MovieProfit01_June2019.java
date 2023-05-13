package programmingBasicsExams;

import java.util.Scanner;

public class MovieProfit01_June2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movieName = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        int tickets = Integer.parseInt(scanner.nextLine());
        double ticketPrice = Double.parseDouble(scanner.nextLine());
        double percentForMovie = Double.parseDouble(scanner.nextLine());

        double totalSum = ((tickets * ticketPrice) * days) - (((tickets * ticketPrice) * days) * (percentForMovie / 100));

        System.out.printf("The profit from the movie %s is %.2f lv.", movieName, totalSum);
    }
}
