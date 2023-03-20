package advancedJanuary2023_03LAB_SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Set<String> carsSet = new LinkedHashSet<>();

        while(!input.equals("END")){
            String direction = input.split(", ")[0];
            String carNumber = input.split(", ")[1];

            if (direction.equals("IN")){
                carsSet.add(carNumber);
            } else if (direction.equals("OUT")){
                if (!carsSet.isEmpty()){
                    carsSet.remove(carNumber);
                }
            }

            input = scanner.nextLine();
        }

        if (carsSet.isEmpty()){
            System.out.println("Parking Lot is Empty");
        } else{
            for (String car: carsSet){
                System.out.println(car);
            }
        }
    }
}
