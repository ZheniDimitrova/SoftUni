package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_AutumnCocktails {

    private  static final int PEAR_SOUR = 150;
    private  static final int THE_HARVEST = 250;
    private  static final int APPLE_HINNY = 300;
    private  static final int HIGH_FASHION = 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> ingredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredientsQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(freshnessStack::push);

        int sum = 0;

        int pearSourCount = 0, theHarvestCount = 0, appleHinnyCount = 0, highFashionCount = 0;

        while(!ingredientsQueue.isEmpty() && !freshnessStack.isEmpty()){

            int ingredient = ingredientsQueue.peek();
            int freshness = freshnessStack.peek();
            sum = ingredient * freshness;

            if (ingredient == 0) {
                ingredientsQueue.poll();
                continue;
            }


            switch (sum) {

                case PEAR_SOUR:
                    pearSourCount++;
                    ingredientsQueue.poll();
                    freshnessStack.pop();
                    break;

                case THE_HARVEST:
                    theHarvestCount++;
                    ingredientsQueue.poll();
                    freshnessStack.pop();
                    break;

                case APPLE_HINNY:
                    appleHinnyCount++;
                    ingredientsQueue.poll();
                    freshnessStack.pop();
                    break;

                case HIGH_FASHION:
                    highFashionCount++;
                    ingredientsQueue.poll();
                    freshnessStack.pop();
                    break;

                default:
                    freshnessStack.pop();
                    if (!ingredientsQueue.isEmpty()) {
                        ingredientsQueue.offer(ingredientsQueue.poll() + 5);
                    }

            }

        }

        if (pearSourCount >= 1 && theHarvestCount >= 1 && appleHinnyCount >= 1 && highFashionCount >= 1) {
            System.out.println("It's party time! The cocktails are ready!");

        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int total = 0;
        if (!ingredientsQueue.isEmpty()) {
            for (int ingredient : ingredientsQueue ){
                total += ingredient;
            }
            System.out.printf("Ingredients left: %d%n", total);

        }

        if (appleHinnyCount >= 1) {
            System.out.printf("# Apple Hinny --> %d%n", appleHinnyCount);
        }
        if (highFashionCount >= 1) {
            System.out.printf("# High Fashion --> %d%n", highFashionCount);
        }
        if (pearSourCount >= 1) {
            System.out.printf("# Pear Sour --> %d%n", pearSourCount);
        }
        if (theHarvestCount >= 1) {
            System.out.printf("# The Harvest --> %d", theHarvestCount);
        }

    }
}
