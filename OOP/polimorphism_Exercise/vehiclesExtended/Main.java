package polimorphism_Exercise.vehiclesExtended;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Vehicle car = getVehicle(scanner);
        Vehicle truck = getVehicle(scanner);
        Vehicle bus = getVehicle(scanner);

        Map<String, Vehicle> vehicleMap = new LinkedHashMap<>();
        vehicleMap.put("Car", car);
        vehicleMap.put("Truck", truck);
        vehicleMap.put("Bus", bus);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            String name = command[0];
            String type = command[1];
            double argument = Double.parseDouble(command[2]);

            switch (name) {

                case "DriveEmpty":
                    Bus buss = (Bus)vehicleMap.get(type);

                case "Drive":
                    System.out.println(vehicleMap.get(type).drive(argument));
                    break;

                case "Refuel":
                    try {
                        vehicleMap.get(type).refuel(argument);

                    } catch (IllegalArgumentException exception) {
                        System.out.println(exception.getMessage());
                    }

                    break;
            }

        }
        vehicleMap.values().forEach(System.out::println);
    }

    private static Vehicle getVehicle(Scanner scanner) {
        String[] vehicleData = scanner.nextLine().split("\\s+");

        String vehicleType = vehicleData[0];
        double fuelAmount = Double.parseDouble(vehicleData[1]);
        double fuelConsumption = Double.parseDouble(vehicleData[2]);
        double tankCapacity = Double.parseDouble(vehicleData[3]);

        switch (vehicleType) {
            case "Car":
                return new Car(fuelAmount, fuelConsumption, tankCapacity);

            case "Truck":
                return new Truck(fuelAmount, fuelConsumption, tankCapacity);

            case "Bus":
                return new Bus(fuelAmount, fuelConsumption, tankCapacity);
            default:
                throw new IllegalArgumentException("Missing vehicleType");
        }

    }

}
