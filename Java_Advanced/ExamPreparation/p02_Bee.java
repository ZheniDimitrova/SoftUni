package Exam_Preparation;

import java.util.Scanner;

public class p02_Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] beeTerritoryMatrix = new char[size][size];

        int beeRow = -1;
        int beeCol = -1;

        for (int row = 0; row < size; row++) {
            char[] line = scanner.nextLine().toCharArray();
            beeTerritoryMatrix[row] = line;
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (beeTerritoryMatrix[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                }
            }

        }

        String command = scanner.nextLine();
        int flowers = 0;

        while (!command.equals("End")) {
            beeTerritoryMatrix[beeRow][beeCol] = '.';

            if (command.equals("right") && beeCol != size - 1) {
                beeCol++;

            } else if (command.equals("left") && beeCol != 0) {
                beeCol--;

            } else if (command.equals("down") && beeRow != size - 1) {
                beeRow++;

            } else if (command.equals("up") && beeRow != 0) {
                beeRow--;
            } else {
                System.out.println("The bee got lost!");
                break;
            }

            if (beeTerritoryMatrix[beeRow][beeCol] == 'f'){
                flowers++;

            } else if (beeTerritoryMatrix[beeRow][beeCol] == 'O'){
                continue;
            }
            beeTerritoryMatrix[beeRow][beeCol] = 'B';
            command = scanner.nextLine();

        }

        if (flowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);

        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        }

        for (int row = 0; row <size ; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(beeTerritoryMatrix[row][col]);
            }
            System.out.println();
        }
    }
}