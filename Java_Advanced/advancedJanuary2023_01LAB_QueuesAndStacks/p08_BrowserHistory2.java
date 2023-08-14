package advancedJanuary2023_01LAB_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p08_BrowserHistory2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque<String> browserHistory = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        while (!input.equals("Home")) {
            if (input.equals("back")) {
                if (browserHistory.isEmpty() || browserHistory.size() == 1) {
                    System.out.println("no previous URLs");
                } else {
                    forward.addFirst(browserHistory.pop());
                    System.out.println(browserHistory.peek());
                }
            } else if (input.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    System.out.println(forward.peek());
                    browserHistory.addFirst(forward.poll());
                }

            } else {
                browserHistory.push(input);
                System.out.println(input);
                forward.clear();
            }

            input = scanner.nextLine();
        }

    }
}
