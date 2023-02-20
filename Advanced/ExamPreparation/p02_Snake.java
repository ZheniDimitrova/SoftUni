package Exam_Preparation;

import java.util.Scanner;

public class p02_Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] territoryMatrix = new char[size][size];
        int snakeRow = -1;
        int snakeCol = -1;
        int firstLiarRow = 0;
        int firstLiarCol = 0;
        int secondLiarRow = 0;
        int secondLiarCol = 0;

        boolean isLairFound = false;

        for (int row = 0; row < size; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                territoryMatrix[row][col] = line[col];

                if (territoryMatrix[row][col] == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                }

                if (territoryMatrix[row][col] == 'B' && !isLairFound) {
                    firstLiarRow = row;
                    firstLiarCol = col;
                    isLairFound = true;
                }
                if (territoryMatrix[row][col] == 'B' && isLairFound) {
                    secondLiarRow = row;
                    secondLiarCol = col;
                }
            }
        }

        int eatenFood = 0;

        while (eatenFood < 10) {
            String command = scanner.nextLine();

            int oldRow = snakeRow;
            int oldCol = snakeCol;

            switch (command) {

                case "up":
                    snakeRow--;

                    break;

                case "down":
                    snakeRow++;
                    break;

                case "right":
                    snakeCol++;
                    break;

                case "left":
                    snakeCol--;
                    break;

            }
            if (snakeRow < 0 || snakeRow >= size || snakeCol < 0 || snakeCol >= size) {
                territoryMatrix[oldRow][oldCol] = '.';
                break;
            }
            if (snakeRow == firstLiarRow && snakeCol == firstLiarCol){
                snakeRow = secondLiarRow;
                snakeCol = secondLiarCol;
                territoryMatrix[firstLiarRow][firstLiarCol] = '.';
            } else if (snakeRow == secondLiarRow && snakeCol == secondLiarCol){
                snakeRow = firstLiarRow;
                snakeCol = firstLiarCol;
                territoryMatrix[secondLiarRow][secondLiarCol] = '.';

            } else if (territoryMatrix[snakeRow][snakeCol] == '*'){
                eatenFood++;
            }
            territoryMatrix[oldRow][oldCol] = '.';
            territoryMatrix[snakeRow][snakeCol] = 'S';
        }

        if (eatenFood >= 10) {
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.printf("Food eaten: %d%n", eatenFood);

        printMatrix(territoryMatrix);


    }
    public static  void printMatrix(char[][] matrix){

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
