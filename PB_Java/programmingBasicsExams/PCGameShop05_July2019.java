package programmingBasicsExams;

import java.util.Scanner;

public class PCGameShop05_July2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int soldGames = Integer.parseInt(scanner.nextLine());
        int hearthstone =0;
        int fornite =0;
        int overwatch =0;
        int others =0;

        for (int i = 0; i < soldGames; i++) {
            String gameName = scanner.nextLine();

            switch (gameName){
                case "Hearthstone":
                    hearthstone++;
                    break;

                case "Fornite":
                    fornite++;
                    break;

                case "Overwatch":
                    overwatch++;
                    break;

                default:
                    others++;

            }
        }
        System.out.printf("Hearthstone - %.2f%%%n", hearthstone * 1.00 / soldGames * 100);
        System.out.printf("Fornite - %.2f%%%n", fornite * 1.00 / soldGames * 100);
        System.out.printf("Overwatch - %.2f%%%n", overwatch * 1.00 / soldGames * 100);
        System.out.printf("Others - %.2f%%%n", others * 1.00 / soldGames * 100);

    }
}
