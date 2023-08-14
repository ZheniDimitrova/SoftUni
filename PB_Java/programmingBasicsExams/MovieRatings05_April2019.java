package programmingBasicsExams;

import java.util.Scanner;

public class MovieRatings05_April2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int filmsNumber = Integer.parseInt(scanner.nextLine());

        double maxRating = Double.MIN_VALUE;
        double minRating = Double.MAX_VALUE;
        String maxFilmName = "";
        String minFilmName = "";

        double sumRatings = 0;

        for (int i = 1; i <= filmsNumber; i++) {
            String filmName = scanner.nextLine();
            double filmRating = Double.parseDouble(scanner.nextLine());

            if (filmRating > maxRating) {
                maxRating = filmRating;
                maxFilmName = filmName;

            }
            if (filmRating < minRating) {
                minRating = filmRating;
                minFilmName = filmName;
            }
            sumRatings += filmRating;
        }
        System.out.printf("%s is with highest rating: %.1f%n", maxFilmName, maxRating);
        System.out.printf("%s is with lowest rating: %.1f%n", minFilmName, minRating);
        System.out.printf("Average rating: %.1f%n", sumRatings / filmsNumber);

    }
}
