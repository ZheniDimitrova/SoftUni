package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_SantaPresentFactory {

    private static final int DOLL = 150;
    private static final int WOODENTRAIN = 250;
    private static final int TEDDYBEAR = 300;
    private static final int BICYCLE = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        ArrayDeque<Integer> magicQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(materialsStack::push);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(magicQueue::offer);

        int sum = 0;

        int dollCount = 0, trainCount = 0, teddyBearCount = 0, bicycleCount = 0;
        while (!materialsStack.isEmpty() && !magicQueue.isEmpty()) {

            int material = materialsStack.peek();
            int magic = magicQueue.peek();

            if (material == 0){
                materialsStack.pop();
            }
            if (magic == 0){
                magicQueue.poll();
            }
            sum = material * magic;

            switch (sum) {
                case DOLL:
                    dollCount++;
                    materialsStack.pop();
                    magicQueue.poll();

                    break;

                case WOODENTRAIN:
                    trainCount++;
                    materialsStack.pop();
                    magicQueue.poll();

                    break;

                case TEDDYBEAR:
                    teddyBearCount++;
                    materialsStack.pop();
                    magicQueue.poll();

                    break;

                case BICYCLE:
                    bicycleCount++;
                    materialsStack.pop();
                    magicQueue.poll();

                    break;

                default:
                    if (sum < 0){
                        int result = material + magic;
                        materialsStack.pop();
                        magicQueue.poll();
                        materialsStack.push(result);

                    } else if (sum > 0) {
                        magicQueue.poll();
                        materialsStack.push(materialsStack.pop() + 15);

                    }
            }

        }

        if ((dollCount >= 1 && trainCount >= 1) || (teddyBearCount >= 1 && bicycleCount >= 1)) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (!materialsStack.isEmpty()){
            System.out.print("Materials left: ");
            System.out.println(materialsStack.toString().replaceAll("[\\[\\]]", ""));
        }
        if (!magicQueue.isEmpty()){
            System.out.print("Magic left: ");
            System.out.println(magicQueue.toString().replaceAll("[\\[\\]]", ""));
        }

        if (bicycleCount > 0){
            System.out.printf("Bicycle: %d%n", bicycleCount);
        }
        if (dollCount > 0) {
            System.out.printf("Doll: %d%n", dollCount);
        }
        if (teddyBearCount > 0) {
            System.out.printf("Teddy bear: %d%n", teddyBearCount);
        }
        if (trainCount > 0){
            System.out.printf("Wooden train: %d", trainCount);
        }

    }
}
