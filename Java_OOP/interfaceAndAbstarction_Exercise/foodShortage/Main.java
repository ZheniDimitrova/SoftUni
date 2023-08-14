package interfaceAndAbstarction_Exercise.foodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        Map<String, Buyer> buyersMap = new HashMap<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String name = input[0];
            int age = Integer.parseInt(input[1]);
            Buyer buyer;

             if (input.length == 4){

                 String id = input[2];
                String birthDate = input[3];

                buyer = new Citizen(name, age, id, birthDate);

             } else {
                 String group = input[2];
                 buyer = new Rebel(name, age, group);

             }
            buyersMap.put(name, buyer);
        }

        String inputName = scanner.nextLine();

        while(!inputName.equals("End")) {
            Buyer buyer = buyersMap.get(inputName);

            if (buyer != null) {
                buyer.buyFood();
            }

            inputName = scanner.nextLine();

        }

       int totalFood =  buyersMap.values().stream().mapToInt(Buyer::getFood).sum();

        System.out.println(totalFood);

    }
}
