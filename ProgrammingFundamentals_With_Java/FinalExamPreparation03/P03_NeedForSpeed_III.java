package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.*;

public class P03_NeedForSpeed_III {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Integer>> carsMap = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] carInfo = scanner.nextLine().split("\\|");
            String carModel = carInfo[0];
            int mileage = Integer.parseInt(carInfo[1]);
            int fuel = Integer.parseInt(carInfo[2]);

            carsMap.putIfAbsent(carModel, new ArrayList<>());
            carsMap.get(carModel).add(mileage);
            carsMap.get(carModel).add(fuel);

        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] commandsArr = input.split(" : ");
            String car = commandsArr[1];

            switch (commandsArr[0]) {
                case "Drive":
                    int distance = Integer.parseInt(commandsArr[2]);
                    int fuelToDrive = Integer.parseInt(commandsArr[3]);

                    if (carsMap.get(car).get(1) < fuelToDrive){
                        System.out.println("Not enough fuel to make that ride");
                    } else {
                        carsMap.get(car).set(0, carsMap.get(car).get(0)+distance);
                        carsMap.get(car).set(1, carsMap.get(car).get(1) - fuelToDrive);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuelToDrive);
                    }

                    if (carsMap.get(car).get(0) >= 100000){
                        System.out.printf("Time to sell the %s!%n", car);
                        carsMap.remove(car);
                    }

                    break;

                case "Refuel":
                    int fuelToRefill = Integer.parseInt(commandsArr[2]);
                    int currentFuel = carsMap.get(car).get(1);
                    int totalFuel = currentFuel + fuelToRefill;
                    int diff = 0;
                    carsMap.get(car).set(1, carsMap.get(car).get(1) + fuelToRefill);

                    if (totalFuel > 75){
                        diff = 75 - currentFuel;
                        totalFuel = 75;

                    } else {
                        diff = fuelToRefill;
                    }
                    carsMap.get(car).set(1, totalFuel);
                    System.out.printf("%s refueled with %d liters%n", car, diff);

                    break;

                case "Revert":
                    int kilometers = Integer.parseInt(commandsArr[2]);
                    carsMap.get(car).set(0, carsMap.get(car).get(0) - kilometers);

                    if (carsMap.get(car).get(0) < 10000){
                        carsMap.get(car).set(0, 10000);
                    } else {
                        System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                    }

                    break;
            }


            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : carsMap.entrySet()) {
            String car = entry.getKey();
            int mileage = entry.getValue().get(0);
            int fuel = entry.getValue().get(1);

            System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n", car, mileage, fuel );
        }

    }
}
