package fundamentalsSeptember2022_06ObjectsAndClasses;

import java.util.Random;
import java.util.Scanner;

public class P01_Exercises_AdvertisementMassage {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] phrases = {"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."};

        String[] events = {"Now I feel good.", "I have succeeded with this product.",
                "Makes miracles. I am happy of the results!", "I cannot believe but now I feel awesome.",
                "Try it yourself, I am very satisfied.", "I feel great!"};

        String[] authors = {"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};

        String[] cities = {"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};

        Random randomMessage = new Random();

        for (int i = 1; i <= n; i++) {
            int randomPhrase = randomMessage.nextInt(phrases.length);
            int randomEvent = randomMessage.nextInt(events.length);
            int randomAuthor = randomMessage.nextInt(authors.length);
            int randomCities = randomMessage.nextInt(cities.length);

            System.out.printf("%s %s %s - %s%n", phrases[randomPhrase], events[randomEvent], authors[randomAuthor], cities[randomCities]);
        }


    }
}