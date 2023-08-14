package advancedJanuary2023_01Ex_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int s = scanner.nextInt();
        int x = scanner.nextInt();

        ArrayDeque<Integer> elements = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            elements.push(scanner.nextInt());
        }

        for (int i = 1; i <= s; i++) {
            if (!elements.isEmpty()) {
                elements.pop();
            }
        }

        if (elements.contains(x)) {
            System.out.println("true");
        } else if (elements.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(Collections.min(elements));
        }

    }
}
