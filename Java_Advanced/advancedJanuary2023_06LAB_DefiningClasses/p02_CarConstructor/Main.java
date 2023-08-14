package advancedJanuary2023_06LAB_DefiningClasses.p02_CarConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> carsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carData = scanner.nextLine().split("\\s+");


            if (carData.length == 1){
                String brand = carData[0];
                Car car = new Car(brand);
                carsList.add(car);

            } else {
                String brand = carData[0];
                String model = carData[1];
                int horsePower = Integer.parseInt(carData[2]);
                Car car = new Car(brand, model, horsePower);
                carsList.add(car);
            }

        }
        for (Car car : carsList){
            System.out.println(car.carInfo());
        }
    }
}
