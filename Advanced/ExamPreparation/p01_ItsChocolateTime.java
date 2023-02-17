package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_ItsChocolateTime {
    private static final double MILK_CHOCOLATE = 30;
    private static final double DARK_CHOCOLATE = 50;
    private static final double BAKING_CHOCOLATE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(milkQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Double::parseDouble).forEach(cacaoStack::push);

        double cacaoAndMilkSum = 0;
        double cacaoPercent = 0;
        int milkCount = 0, darkCount = 0, bakingCount = 0;

        while (!milkQueue.isEmpty() && !cacaoStack.isEmpty()) {

            double milk = milkQueue.peek();
            double cacao = cacaoStack.peek();
            cacaoAndMilkSum = milk + cacao;
            cacaoPercent = (cacao / cacaoAndMilkSum) * 100;


            if (cacaoPercent == MILK_CHOCOLATE) {
                milkCount++;
                milkQueue.poll();
                cacaoStack.pop();

            } else if (cacaoPercent == DARK_CHOCOLATE) {
                darkCount++;
                milkQueue.poll();
                cacaoStack.pop();

            } else if (cacaoPercent == BAKING_CHOCOLATE) {
                bakingCount++;
                milkQueue.poll();
                cacaoStack.pop();

            } else {
                cacaoStack.pop();
                if (!milkQueue.isEmpty()) {
                    milkQueue.offer(milkQueue.poll() + 10);
                }

            }
        }
        if (milkCount >= 1 && darkCount >= 1 && bakingCount >= 1) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");

        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        if (bakingCount >= 1){
            System.out.printf("# Baking Chocolate --> %d%n", bakingCount);
        }
        if (darkCount >= 1){
            System.out.printf("# Dark Chocolate --> %d%n", darkCount);
        }
        if (milkCount >= 1){
            System.out.printf("# Milk Chocolate --> %d%n", milkCount);
        }

    }
}
