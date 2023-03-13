package advancedJanuary2023_01LAB_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p06_HotPotato_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] names = scanner.nextLine().split(" ");
        int count = Integer.parseInt(scanner.nextLine());
        ArrayDeque <String> hotPotato = new ArrayDeque<>();

        for (int name = 0; name < names.length; name++) {
            String currentName = names[name];
            hotPotato.offer(currentName);

        }

        while (hotPotato.size() > 1){
            for (int child = 1; child < count ; child++) {
                String currentChild = hotPotato.poll();
                hotPotato.offer(currentChild);
            }
            String nameToRemove = hotPotato.poll();
            System.out.println("Removed " + nameToRemove);
        }
        String lastChild = hotPotato.peek();
        System.out.println("Last is " + lastChild);
    }
}
