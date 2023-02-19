package Exam_Preparation;

import java.util.Scanner;

public class p02_FormulaOne {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        int playerRow = -1;
        int playerCol = -1;

        for (int row = 0; row < size; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line[col];
                if (matrix[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        boolean isWon = false;

        for (int i = 1; i <= commandsCount; i++) {
            String command = scanner.nextLine();

            int newRow = 0;
            int newCol = 0;

            switch (command) {

                case "up":
                    newRow = isItOutside(playerRow - 1, size);
                    newCol = isItOutside(playerCol, size);

                    if (matrix[newRow][newCol] == 'B') {
                        newRow = isItOutside(playerRow - 2, size);
                        newCol = isItOutside(playerCol, size);
                    }


                    break;

                case "down":
                    newRow = isItOutside(playerRow + 1, size);
                    newCol = isItOutside(playerCol, size);
                    if (matrix[newRow][newCol] == 'B') {
                        newRow = isItOutside(playerRow + 2, size);
                        newCol = isItOutside(playerCol, size);
                    }

                    break;

                case "right":
                    newRow = isItOutside(playerRow, size);
                    newCol = isItOutside(playerCol + 1, size);

                    if (matrix[newRow][newCol] == 'B') {
                        newRow = isItOutside(playerRow, size);
                        newCol = isItOutside(playerCol + 2, size);
                    }

                    break;

                case "left":
                    newRow = isItOutside(playerRow, size);
                    newCol = isItOutside(playerCol - 1, size);

                    if (matrix[newRow][newCol] == 'B') {
                        newRow = isItOutside(playerRow, size);
                        newCol = isItOutside(playerCol - 2, size);
                    }

                    break;

            }

            if (matrix[newRow][newCol] == 'T') {
                newRow = playerRow;
                newCol = playerCol;

            } else {

                if (matrix[newRow][newCol] == 'F') {
                    isWon = true;
                }
                matrix[playerRow][playerCol] = '.';
                matrix[newRow][newCol] = 'P';
                playerRow = newRow;
                playerCol = newCol;
            }
        }

        if (isWon) {
            System.out.println("Well done, the player won first place!");

        } else {
            System.out.println("Oh no, the player got lost on the track!");

        }

        printMatrix(matrix);

    }

    public static int isItOutside(int value, int size) {

        if (value < 0) {
            value = size - 1;

        } else if (value >= size) {
            value = 0;
        }
        return value;
    }


    public static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}


