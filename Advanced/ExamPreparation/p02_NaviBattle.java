package Exam_Preparation;

import java.util.Scanner;

public class p02_NaviBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int submarineRow = -1;
        int submarineCol = -1;

        for (int row = 0; row < size; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line[col];
                if (matrix[row][col] == 'S') {
                    submarineRow = row;
                    submarineCol = col;

                }
            }
        }

        String command = scanner.nextLine();
        int minesCount = 0;
        int cruiserCount = 0;

        while(true){

            matrix[submarineRow][submarineCol] = '-';

            switch (command) {

                case "up":
                    submarineRow--;

                    break;

                case "down":
                    submarineRow++;
                    break;

                case "right":
                    submarineCol++;
                    break;

                case "left":
                    submarineCol--;
                    break;
            }

            if (matrix[submarineRow][submarineCol] == '-') {
                matrix[submarineRow][submarineCol] = 'S';


            } else if (matrix[submarineRow][submarineCol] == '*') {
                minesCount++;
                matrix[submarineRow][submarineCol] = 'S';

                if (minesCount == 3) {
                    System.out.printf("Mission failed, U-9 disappeared! Last known coordinates [%d, %d]!%n", submarineRow, submarineCol);
                    break;
                }


            } else if (matrix[submarineRow][submarineCol] == 'C') {
                cruiserCount++;
                matrix[submarineRow][submarineCol] = 'S';

                if (cruiserCount == 3) {
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
            }
           command = scanner.nextLine();

        }

        printMatrix(matrix);

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
