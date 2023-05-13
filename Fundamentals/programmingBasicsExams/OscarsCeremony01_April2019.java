package programmingBasicsExams;

import java.util.Scanner;

public class OscarsCeremony01_April2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rentAHall = Integer.parseInt(scanner.nextLine());
        double statuettesPrice = rentAHall - (rentAHall * 0.3);
        double catering = statuettesPrice - (statuettesPrice * 0.15);
        double voicing = catering / 2;

        double priceResult = rentAHall + statuettesPrice + catering + voicing;

        System.out.printf("%.2f", priceResult);
    }
}
