package Exam_Preparation;

import java.util.Scanner;

public class p02_ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());
        int rows = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][];
        int parisRow = -1;
        int parisCol = -1;

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                }
            }
        }

        while (true) {

            String[] input = scanner.nextLine().split("\\s+");

            String command = input[0];
            int spartanRow = Integer.parseInt(input[1]);
            int spartanCol = Integer.parseInt(input[2]);

            matrix[spartanRow][spartanCol] = 'S';
            matrix[parisRow][parisCol] = '-';

            switch (command) {

                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    break;

                case "down":
                    if (parisRow + 1 < matrix.length) {
                        parisRow++;
                    }
                    break;

                case "right":
                    if (parisCol + 1 < matrix.length) {
                        parisCol++;
                    }

                    break;

                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }

                    break;

            }
            parisEnergy--;

            if (parisEnergy <= 0) {
                matrix[parisRow][parisCol] = 'X';
                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                break;
            }

            if (matrix[parisRow][parisCol] == 'S') {
                parisEnergy -= 2;
                if (parisEnergy <= 0) {
                    matrix[parisRow][parisCol] = 'X';
                    System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                    break;

                } else {
                    matrix[parisRow][parisCol] = '-';
                }

            } else if (matrix[parisRow][parisCol] == 'H') {

                matrix[parisRow][parisCol] = '-';

                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
                break;
            }

        }

        printMatrix(matrix);

    }

    public static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
