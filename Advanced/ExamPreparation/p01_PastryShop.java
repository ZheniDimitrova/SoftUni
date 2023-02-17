package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_PastryShop {

    private static final int BISCUIT = 25;
    private static final int CAKE = 50;
    private static final int PASTRY = 75;
    private static final int PIE = 100;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(liquidsQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(ingredientsStack::push);

       int  biscuitCount = 0, cakeCount = 0,  pastryCount = 0,  pieCount = 0;

        while(!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()){

            int liquid = liquidsQueue.poll();
            int ingredient = ingredientsStack.pop();

            int sum = liquid + ingredient;

            switch (sum){
                case BISCUIT: biscuitCount++; break;
                case CAKE: cakeCount++; break;
                case PASTRY: pastryCount++; break;
                case PIE: pieCount++; break;

                default: ingredientsStack.push(ingredient + 3);
            }
        }
        if (biscuitCount >= 1 && cakeCount >= 1 && pastryCount >= 1 && pieCount >=1) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
        System.out.print("Liquids left: ");
        if (liquidsQueue.isEmpty()){
            System.out.println("none");
        } else {
            System.out.println(liquidsQueue.toString().replaceAll("[\\[\\]]", ""));

        }
        System.out.print("Ingredients left: ");
        if (ingredientsStack.isEmpty()){
            System.out.println("none");
        } else {
            System.out.println(ingredientsStack.toString().replaceAll("[\\[\\]]", ""));
        }

        System.out.printf("Biscuit: %d\nCake: %d\nPie: %d\nPastry: %d", biscuitCount, cakeCount, pieCount, pastryCount);

    }
}
