package advancedJanuary2023_01LAB_QueuesAndStacks;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class p07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PriorityQueue<String> children = new PriorityQueue<>();

        String[] names = scanner.nextLine().split(" ");
        int count = Integer.parseInt(scanner.nextLine());

        Collections.addAll(children, names);

        int currentSteps = 1;

        while(children.size() > 1){
            for (int i = 1; i < count; i++) {
                String child = children.poll();
                children.offer(child);
            }

            if (isPrime(currentSteps)){
                System.out.println("Prime " + children.peek());
            } else {
                String childToRemove = children.poll();
                System.out.println("Removed " + childToRemove);
            }
            currentSteps++;

        }
        System.out.println("Last is " + children.peek());

    }
    public static boolean isPrime (int number){
        if (number == 1){
            return false;
        }


        for (int i = 2; i < number ; i++) {
            if (number % i == 0){
                return false;
            }

        }
        return true;
    }

}
