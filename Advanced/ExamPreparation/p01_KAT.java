package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_KAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> licensePlatesQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(licensePlatesQueue::offer);
        Arrays.stream(scanner.nextLine().split(",\\s+")).map(Integer::parseInt).forEach(carsStack::push);

        int registeredCars = 0;
        int days = 0;


        while(!licensePlatesQueue.isEmpty() && !carsStack.isEmpty()) {

            int licensePlatesForADay = licensePlatesQueue.peek();
            int carsForADay = carsStack.peek();
            days++;

            if (licensePlatesForADay == (carsForADay * 2)) {
                carsStack.pop();
                licensePlatesQueue.poll();
                registeredCars += carsForADay;

            } else if (licensePlatesForADay > (carsForADay * 2)) {
                int remainPlates = licensePlatesForADay - (carsForADay * 2);
                carsStack.pop();
                licensePlatesQueue.poll();
                licensePlatesQueue.offer(remainPlates);
                registeredCars += carsForADay;

            } else {
               int remainCars = carsForADay - (licensePlatesForADay / 2);
                licensePlatesQueue.poll();
                carsStack.pop();
                carsStack.offer(remainCars);
                int registeredForADay = carsForADay - remainCars;
                registeredCars += registeredForADay;
            }
        }


        System.out.printf("%d cars were registered for %d days!%n", registeredCars, days);

        if (licensePlatesQueue.isEmpty() && carsStack.isEmpty()) {
            System.out.println("Good job! There is no queue in front of the KAT!");


        } else if (!licensePlatesQueue.isEmpty()) {
            int sum = 0;
            for (Integer plate : licensePlatesQueue) {
                sum += plate;
            }
            System.out.printf("%d license plates remain!%n", sum);

        } else {
            int sum = 0;
            for (Integer car : carsStack) {
                sum += car;
            }
            System.out.printf("%d cars remain without license plates!%n", sum);
        }

    }
}


