package fundamentalsSeptember2022_01Basic_Exercises;

import java.util.Scanner;

public class Vacation_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String day = scanner.nextLine();

        double price = 0;

        switch (typeOfGroup) {
            case "Students":
                switch (day) {
                    case "Friday":
                        price =  8.45;
                        break;
                    case "Saturday":
                        price =  9.80;
                        break;
                    case "Sunday":
                        price =  10.46;
                        break;
                } if (numberOfPeople >= 30){
                    price = price - price * 0.15;
            }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        price =  10.90;
                        break;
                    case "Saturday":
                        price =  15.60;
                        break;
                    case "Sunday":
                        price =  16;
                        break;
                }
                if (numberOfPeople >= 100){
                   numberOfPeople -= 10;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        price =  15;
                        break;
                    case "Saturday":
                        price =  20;
                        break;
                    case "Sunday":
                        price =  22.50;
                        break;
                }
                if (numberOfPeople >= 10 && numberOfPeople <= 20){
                    price = price - price * 0.05;
                }
                break;
        }
        double totalPrice = numberOfPeople * price;
        System.out.printf("Total price: %.2f", totalPrice);
    }
}
