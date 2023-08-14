package programmingBasicsExams;

import java.util.Scanner;

public class FootballTournament05_July2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String footballTeamName = scanner.nextLine();
        int numberOfFootballGames = Integer.parseInt(scanner.nextLine());
        int countW = 0;
        int countD = 0;
        int countL = 0;
        int totalCountGames = 0;
        int points = 0;

        if (numberOfFootballGames == 0) {
            System.out.printf("%s hasn't played any games during this season.", footballTeamName);
            return;
        }
        for (int i = 0; i < numberOfFootballGames; i++) {
            char input = scanner.nextLine().charAt(0);

            switch (input) {
                case 'W':
                    countW++;
                    totalCountGames++;
                    points += 3;
                    break;
                case 'D':
                    countD++;
                    totalCountGames++;
                    points += 1;
                    break;
                case 'L':
                    countL++;
                    totalCountGames++;
                    break;
            }

        }
        System.out.printf("%s has won %d points during this season.%n", footballTeamName, points);
        System.out.println("Total stats:");
        System.out.printf("## W: %d%n",countW);
        System.out.printf("## D: %d%n",countD);
        System.out.printf("## L: %d%n",countL);
        System.out.printf("Win rate: %.2f%%",countW * 1.00 / totalCountGames   * 100);
    }
}
