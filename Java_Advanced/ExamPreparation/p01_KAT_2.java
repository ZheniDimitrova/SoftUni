package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_KAT_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licensePlatesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(licensePlatesQueue::offer);
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(carsStack::push);

        int registeredCars = 0;
        int days = 0;


        while(!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()) {

            int licensePlates = licensePlatesQueue.poll();
            int car = carsStack.pop();

            int remainCars = 0;
            int remainPlates = 0;

            int possibleCars = licensePlates / 2;

            if (possibleCars == car) {
                registeredCars += possibleCars;
                days++;


            } else if (possibleCars < car) {
                registeredCars += possibleCars;
                days++;
                remainCars += (car - possibleCars);
                carsStack.add(remainCars);


            } else {
                registeredCars += car;
                days++;
                remainPlates = (possibleCars - car) * 2;
                licensePlatesQueue.add(remainPlates);

            }

        }

        System.out.printf("%d cars were registered for %d days!%n", registeredCars, days);

        if (licensePlatesQueue.isEmpty() && carsStack.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");
        }

        if (!licensePlatesQueue.isEmpty()) {
            int sum = 0;
            for (int plate : licensePlatesQueue) {
                sum += plate;
            }
            System.out.printf("%d license plates remain!", sum);
        }

        if (!carsStack.isEmpty()) {
            int sum = 0;
            for (int car : carsStack) {
                sum += car;
            }
            System.out.printf("%d cars remain without license plates!", sum);
        }

    }
}


