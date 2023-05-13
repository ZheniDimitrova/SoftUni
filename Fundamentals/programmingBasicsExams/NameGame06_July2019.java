package programmingBasicsExams;

import java.util.Scanner;

public class NameGame06_July2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String namePlayer = scanner.nextLine();
        int points = 0;
        int maxPoints = Integer.MIN_VALUE;
        String winnerName = "";

        while (!namePlayer.equals("Stop")) {
            for (int i = 0; i < namePlayer.length(); i++) {
                int number = Integer.parseInt(scanner.nextLine());
                char letter = namePlayer.charAt(i);
                if (number == letter) {
                    points += 10;
                } else {
                    points += 2;
                }
            }
            if (points >= maxPoints) {
                maxPoints = points;
                winnerName = namePlayer;
            }
            namePlayer = scanner.nextLine();
            points = 0;
        }
        System.out.printf("The winner is %s with %d points!", winnerName, maxPoints);

    }
}
