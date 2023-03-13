package advancedJanuary2023_01LAB_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p01_BrowserHistory_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browserHistory.isEmpty() || browserHistory.size() == 1) {
                    System.out.println("no previous URLs");
                } else {
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            } else {
                browserHistory.push(input);
                System.out.println(input);
            }

            input = scanner.nextLine();
        }

    }
}
