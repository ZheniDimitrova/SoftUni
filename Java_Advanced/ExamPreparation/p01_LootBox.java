package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(firstQueue::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(secondStack::push);

        int sum = 0;
        int loot = 0;

        while (!firstQueue.isEmpty() && !secondStack.isEmpty()) {
            int firstElem = firstQueue.peek();
            int secondElem = secondStack.pop();
            sum = firstElem + secondElem;

            if (sum % 2 == 0) {
                loot += sum;
                firstQueue.poll();

            } else {
                firstQueue.offer(secondElem);
            }

        }
        if (firstQueue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }
        if (loot >= 100) {
            System.out.printf("Your loot was epic! Value: %d", loot);
        } else {
            System.out.printf("Your loot was poor... Value: %d", loot);
        }
    }
}
