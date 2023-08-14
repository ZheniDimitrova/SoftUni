package Exam_Preparation;

import java.util.*;

public class p01_FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liliesStack = new ArrayDeque<>();
        ArrayDeque<Integer> rosesQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(liliesStack::push);
        Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).forEach(rosesQueue::offer);

        int wreaths = 0;
        int storedFlowers = 0;

        while (!liliesStack.isEmpty() && !rosesQueue.isEmpty()) {

            int lily = liliesStack.pop();
            int rose = rosesQueue.poll();

            int sum = lily + rose;

            while (sum > 15) {
                lily -= 2;
                 sum = lily + rose;
            }

            if (sum == 15) {
                wreaths++;


            }  else  {
                storedFlowers += sum;

            }

        }
        wreaths = wreaths + storedFlowers / 15;

        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!%n", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }

    }
}
