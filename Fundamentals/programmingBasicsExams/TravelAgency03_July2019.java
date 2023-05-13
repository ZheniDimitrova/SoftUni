package programmingBasicsExams;

import java.util.Scanner;

public class TravelAgency03_July2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String town = scanner.nextLine();
        String packageType = scanner.nextLine();
        String vipDiscount = scanner.nextLine();
        int numberOfDays = Integer.parseInt(scanner.nextLine());
        double priceADay = 0;

        switch (town) {
            case "Bansko":
            case "Borovets":
                switch (packageType) {
                    case "noEquipment":
                        priceADay = 80;
                        if (vipDiscount.equals("yes")){
                            priceADay = priceADay - (priceADay * 0.05);
                        }
                        break;
                    case "withEquipment":
                        priceADay = 100;
                        if (vipDiscount.equals("yes")){
                            priceADay = priceADay - (priceADay * 0.10);
                        }
                        break;
                    default:
                        System.out.println("Invalid input!");
                        return;
                }
                break;
            case "Varna":
            case "Burgas":
                switch (packageType){
                    case "noBreakfast":
                        priceADay = 100;
                        if (vipDiscount.equals("yes")){
                            priceADay = priceADay - (priceADay * 0.07);
                        }
                        break;
                    case "withBreakfast":
                        priceADay = 130;
                        if (vipDiscount.equals("yes")){
                            priceADay = priceADay - (priceADay * 0.12);
                        }
                        break;
                    default:
                        System.out.println("Invalid input!");
                        return;
                }
                break;
            default:
                System.out.println("Invalid input!");
                return;
        }

        if (numberOfDays > 7){
            numberOfDays--;
        }
        double totalPrice = numberOfDays * priceADay;
        if(numberOfDays < 1){
            System.out.println("Days must be positive number!");

        } else{
            System.out.printf("The price is %.2flv! Have a nice time!", totalPrice);
        }
    }
}


