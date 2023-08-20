package fundamentalsSeptember2022_01Basic_Exercises;

import java.util.Scanner;

public class RageExpenses_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headSetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int brokenHeadset = lostGamesCount / 2;
        int brokenMouse = lostGamesCount /3;
        int brokenKeyboard = lostGamesCount / 6;
        int brokenDisplay = lostGamesCount / 12;

        double totalSum = brokenHeadset * headSetPrice + brokenMouse * mousePrice + brokenKeyboard * keyboardPrice + brokenDisplay * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.", totalSum);

    }
}
