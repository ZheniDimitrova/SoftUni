package exercise_P05_VehicleCatalog;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Vehicle> vehicleList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] vehicleData = input.split(" ");

            String type = vehicleData[0];
            String model = vehicleData[1];
            String colour = vehicleData[2];
            int horsePower = Integer.parseInt(vehicleData[3]);

            Vehicle currentVehicle = new Vehicle(type, model, colour, horsePower);
            vehicleList.add(currentVehicle);

            input = scanner.nextLine();
        }
        String command = scanner.nextLine();

        while (!command.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicleList) {
                if (command.equals(vehicle.getModel())) {
                    System.out.println(vehicle);
                }
            }
            command = scanner.nextLine();
        }
        int sumCarsHp = 0;
        int sumTrucksHp = 0;
        int cars = 0;
        int trucks = 0;

        for (Vehicle vehicle : vehicleList) {
            if (vehicle.getTypeOfVehicle().equals("car") || vehicle.getTypeOfVehicle().equals("Car")) {
                cars++;
                sumCarsHp += vehicle.getHorsePower();
            } else if (vehicle.getTypeOfVehicle().equals("truck") || vehicle.getTypeOfVehicle().equals("Truck")) {
                trucks++;
                sumTrucksHp += vehicle.getHorsePower();

            }
        }
        double averageCarsHp = sumCarsHp * 1.0 / cars;
        double averageTrucksHp = sumTrucksHp * 1.0 / trucks;

        if (cars == 0) {
            averageCarsHp = 0;
        } else if (trucks == 0) {
            averageTrucksHp = 0;
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageCarsHp);
        System.out.printf("Trucks have average horsepower of: %.2f.%n", averageTrucksHp);
    }
}

