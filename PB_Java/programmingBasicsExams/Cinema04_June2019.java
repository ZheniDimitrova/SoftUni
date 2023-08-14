package programmingBasicsExams;

import java.util.Scanner;

public class Cinema04_June2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int allPlaces = Integer.parseInt(scanner.nextLine());
        int ticketPrice = 5;
        int cinemaIncome = 0;
        String input = scanner.nextLine();

        while (!input.equals("Movie time!")) {
            int people = Integer.parseInt(input);
            int peoplePrice = people * ticketPrice;
            if (people % 3 == 0) {
                peoplePrice = peoplePrice - 5;
            }
            allPlaces -= people;
            if (allPlaces < 0) {
                System.out.println("The cinema is full.");
                break;
            }
            cinemaIncome += peoplePrice;

            input = scanner.nextLine();
        }
        if (input.equals("Movie time!")) {
            System.out.printf("There are %d seats left in the cinema.%n", allPlaces);
        }

        System.out.printf("Cinema income - %d lv.", cinemaIncome);

    }
}
