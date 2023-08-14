package advancedJanuary2023_01Ex_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class p03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> elements = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String[] command = scanner.nextLine().split("\\s+");

            switch (command[0]) {
                case "1":
                    int num = Integer.parseInt(command[1]);
                    elements.push(num);
                    break;

                case "2":
                    if (!elements.isEmpty()) {
                        elements.pop();
                    }
                    break;

                case "3":
                    if (!elements.isEmpty()) {
                        System.out.println(Collections.max(elements));
                    }

                    break;
            }
        }
    }
}
