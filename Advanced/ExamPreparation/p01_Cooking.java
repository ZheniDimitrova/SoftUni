package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;


public class p01_Cooking {

    private static final int BREAD = 25;
    private static final int CAKE = 50;
    private static final int PASTRY = 75;
    private static final int PIE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueLiquids = new ArrayDeque<>();
        ArrayDeque<Integer> stackIngredients = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(queueLiquids::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(stackIngredients::push);

        int sum = 0;

        int breadCount = 0, cakeCount = 0, pastryCount = 0, pieCount = 0;

        while (!queueLiquids.isEmpty() && !stackIngredients.isEmpty()) {

            int liquid = queueLiquids.poll();
            int ingredient = stackIngredients.pop();

            sum = liquid + ingredient;

            switch (sum) {

                case BREAD:
                    breadCount++;
                    break;

                case CAKE:
                    cakeCount++;
                    break;

                case PASTRY:
                    pastryCount++;
                    break;

                case PIE:
                    pieCount++;
                    break;

                default: stackIngredients.push(ingredient + 3);
            }

        }

        if (breadCount >= 1 && cakeCount >= 1 && pastryCount >= 1 && pieCount >= 1) {

            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        System.out.print("Liquids left: ");
        if (queueLiquids.isEmpty()){
            System.out.println("none");

        } else {
            System.out.println(queueLiquids.toString().replaceAll("[\\[\\]]", ""));
        }

        System.out.print("Ingredients left: ");
        if (stackIngredients.isEmpty()) {
            System.out.println("none");
        } else {
            System.out.println(stackIngredients.toString().replaceAll("[\\[\\]]", ""));
        }

        System.out.printf("Bread: %d%nCake: %d%nFruit Pie: %d%nPastry: %d", breadCount, cakeCount, pieCount, pastryCount);

    }
}


