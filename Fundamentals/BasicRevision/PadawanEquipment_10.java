package fundamentalsSeptember2022_01Basic_Exercises;

import java.util.Scanner;

public class PadawanEquipment_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double budget = Double.parseDouble(scanner.nextLine());
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        double oneLightSaberPrice = Double.parseDouble(scanner.nextLine());
        double oneRobePrice = Double.parseDouble(scanner.nextLine());
        double oneBeltPrice = Double.parseDouble(scanner.nextLine());

        double sabersPrice = numberOfStudents * oneLightSaberPrice + Math.ceil(numberOfStudents * 0.10) * oneLightSaberPrice;
        double robesPrice = numberOfStudents * oneRobePrice;
        double beltsPrice = numberOfStudents * oneBeltPrice - (numberOfStudents / 6) * oneBeltPrice;
        double totalPrice = sabersPrice + robesPrice + beltsPrice;

        if (budget >= totalPrice){
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        } else{
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - budget);
        }
    }
}
