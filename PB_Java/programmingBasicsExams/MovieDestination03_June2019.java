package programmingBasicsExams;

import java.util.Scanner;

public class MovieDestination03_June2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String destination = scanner.nextLine();
        String season = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());

        double price = 0;

        switch (destination) {
            case "Dubai":
                switch (season) {
                    case "Summer":
                        price = 40000;
                        break;
                    case "Winter":
                        price = 45000;
                        break;
                }
                break;
            case "Sofia":
                switch (season) {
                    case "Summer":
                        price = 12500;
                        break;
                    case "Winter":
                        price = 17000;
                        break;
                }
                break;
            case "London":
                switch (season) {
                    case "Summer":
                        price = 20250;
                        break;
                    case "Winter":
                        price = 24000;
                        break;
                }
                break;
        }
        double totalMoviePrice = days * price;
        if (destination.equals("Dubai")) {
            totalMoviePrice = totalMoviePrice - totalMoviePrice * 0.3;
        } else if (destination.equals("Sofia")) {
            totalMoviePrice = totalMoviePrice + totalMoviePrice * 0.25;
        }
        if (budget >= totalMoviePrice) {
            System.out.printf("The budget for the movie is enough! We have %.2f leva left!", budget - totalMoviePrice);
        } else {
            System.out.printf("The director needs %.2f leva more!", totalMoviePrice - budget);
        }
    }
}
