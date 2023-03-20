package advancedJanuary2023_03LAB_SetsAndMaps;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class p03_CardGameVoina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();

        String[] first = scanner.nextLine().split("\\s+");
        for (int i = 0; i < first.length; i++) {
            int currentFirst = Integer.parseInt(first[i]);
            firstPlayer.add(currentFirst);
        }
        String[] second = scanner.nextLine().split("\\s+");
        for (int i = 0; i < second.length; i++) {
            int currentSecond = Integer.parseInt(second[i]);
            secondPlayer.add(currentSecond);
        }

        for (int i = 1; i <= 50; i++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) {
                break;
            }
            Integer playerOne = firstPlayer.iterator().next();
            Integer playerTwo = secondPlayer.iterator().next();
            firstPlayer.remove(playerOne);
            secondPlayer.remove(playerTwo);

            if (playerOne > playerTwo) {
                firstPlayer.add(playerOne);
                firstPlayer.add(playerTwo);
            } else if (playerTwo > playerOne) {
                secondPlayer.add(playerOne);
                secondPlayer.add(playerTwo);
            }

        }

        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
