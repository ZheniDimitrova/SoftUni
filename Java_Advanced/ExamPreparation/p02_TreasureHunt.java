package Exam_Preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p02_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] info = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(info[0]);
        int cols = Integer.parseInt(info[1]);

        char[][] matrix = new char[rows][cols];
        int playerRow = -1;
        int playerCol = -1;
        int treasureRow = -1;
        int treasureCol = -1;

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().replaceAll(" ", "").toCharArray();
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 'Y') {
                    playerRow = row;
                    playerCol = col;
                }
                if (matrix[row][col] == 'X') {
                    treasureRow = row;
                    treasureCol = col;
                }

            }
        }

        String command = scanner.nextLine();
        List<String> treasurePath = new ArrayList<>();

        while (!command.equals("Finish")) {
            int oldRow = playerRow;
            int oldCol = playerCol;


            switch (command) {

                case "up":
                    playerRow--;

                    break;

                case "down":
                    playerRow++;
                    break;

                case "right":
                    playerCol++;
                    break;

                case "left":
                    playerCol--;
                    break;
            }

            if(playerRow < 0 || playerCol < 0 || playerRow >= rows || playerCol >= cols){
                playerRow = oldRow;
                playerCol = oldCol;

            } else if (matrix[playerRow][playerCol] == 'T'){
                playerRow = oldRow;
                playerCol = oldCol;

            } else {
                matrix[oldRow][oldCol] = '-';
                matrix[playerRow][playerCol] = 'Y';

                treasurePath.add(command);
            }


            command = scanner.nextLine();

        }

        if (playerRow == treasureRow && playerCol == treasureCol){
            System.out.println("I've found the treasure!");
            System.out.print("The right path is ");

            System.out.println(String.join(", ", treasurePath));

        } else {
            System.out.println("The map is fake!");
        }

    }

}
