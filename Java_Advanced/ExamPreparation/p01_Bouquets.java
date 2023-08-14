package Exam_Preparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class p01_Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(tulipsStack::push);
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(daffodilsQueue::offer);

        int bouquets = 0;
        int storedForLater = 0;

        while(!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()){

            int tulip = tulipsStack.peek();
            int daffodil = daffodilsQueue.peek();
            int sum = tulip + daffodil;

            while (sum > 15) {
                tulip -= 2;
                sum = tulip + daffodil;

            }
            if (sum == 15){
                bouquets++;

            } else if (sum < 15) {
                storedForLater += sum;

            }
            tulipsStack.pop();
            daffodilsQueue.poll();
        }
        bouquets += storedForLater / 15;

        if (bouquets >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }
    }
}
