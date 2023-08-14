package programmingBasicsExams;

import java.util.Scanner;

public class cinemaTicket06_April2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String filmName = scanner.nextLine();

        int standardCount = 0;
        int studentCount = 0;
        int kidCount = 0;
        double totalTicketsCounter = 0;
        boolean isFinished = false;

        while (!filmName.equals("Finish")) {
            int freeSeats = Integer.parseInt(scanner.nextLine());
            double currentFilmCounter = 0;
            for (int i = 1; i <= freeSeats; i++) {
                String command = scanner.nextLine();

                if (command.equals("End")) {
                    break;
                }
                switch (command) {
                    case "student":
                        studentCount++;
                        totalTicketsCounter++;
                        break;

                    case "standard":
                        standardCount++;
                        totalTicketsCounter++;
                        break;

                    case "kid":
                        kidCount++;
                        totalTicketsCounter++;
                        break;

                }
                currentFilmCounter++;
            }
            System.out.printf("%s - %.2f%% full.%n", filmName, ( currentFilmCounter/ freeSeats) * 100);

            filmName = scanner.nextLine();

            if (filmName.equals("Finish")) {
                isFinished = true;
            }
        }

        if (isFinished) {
            System.out.printf("Total tickets: %.0f%n", totalTicketsCounter);
            System.out.printf("%.2f%% student tickets.%n", (studentCount / totalTicketsCounter) * 100);
            System.out.printf("%.2f%% standard tickets.%n", (standardCount / totalTicketsCounter) * 100);
            System.out.printf("%.2f%% kids tickets.", (kidCount / totalTicketsCounter) * 100);
        }
    }
}