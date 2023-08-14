package programmingBasicsExams;

import java.util.Scanner;

public class FilmPremiere03_June2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String movie = scanner.nextLine();
        String packet = scanner.nextLine();
        int tickets = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (movie){
            case "John Wick":
                switch (packet){
                    case "Drink":
                        price = 12;
                    break;
                    case "Popcorn":
                        price = 15;
                        break;
                    case "Menu":
                        price = 19;
                        break;
                }
                break;
            case "Star Wars":
                switch (packet){
                    case "Drink":
                        price = 18;
                        break;
                    case "Popcorn":
                        price = 25;
                        break;
                    case "Menu":
                        price = 30;
                        break;
                }
                break;
            case "Jumanji":
                switch (packet){
                    case "Drink":
                        price = 9;
                        break;
                    case "Popcorn":
                        price = 11;
                        break;
                    case "Menu":
                        price = 14;
                        break;
                }
                break;

        }
        if (movie.equals("Star Wars") && tickets >= 4){
            price = price - price * 0.3;
        } else if (movie.equals("Jumanji") && tickets ==2){
            price = price - price * 0.15;
        }

        System.out.printf("Your bill is %.2f leva.", price * tickets);
    }
}
