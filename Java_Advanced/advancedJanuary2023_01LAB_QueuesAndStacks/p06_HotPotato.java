package advancedJanuary2023_01LAB_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int number = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> childrenQueue = new ArrayDeque<>();

        for (int i = 0; i < names.length; i++) {
            childrenQueue.offer(names[i]);
        }
        while(childrenQueue.size() != 1){
            for (int i = 1; i < number; i++) {
                String child = childrenQueue.poll();
                childrenQueue.offer(child);
            }
            String removedChild = childrenQueue.poll();
            System.out.println("Removed " + removedChild);
        }
        String lastChild = childrenQueue.peek();
        System.out.println("Last is " + lastChild);
    }
}
