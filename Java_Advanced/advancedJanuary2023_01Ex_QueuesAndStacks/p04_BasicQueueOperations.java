package advancedJanuary2023_01Ex_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> numbersQueue = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            numbersQueue.offer(scanner.nextInt());
        }
        for (int i = 1; i <= s; i++) {
            if (!numbersQueue.isEmpty()) {
                numbersQueue.poll();
            }
        }

        if (numbersQueue.contains(x)) {
            System.out.println("true");
        } else if (numbersQueue.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(numbersQueue));
        }
    }
}
