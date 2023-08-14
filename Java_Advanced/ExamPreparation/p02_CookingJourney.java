package Exam_Preparation;

import java.util.Scanner;

public class p02_CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        int rowMatrix = -1;
        int colMatrix = -1;
        int firstPillarRow = 0;
        int firstPillarCol = 0;
        int secondPillarRow = 0;
        int secondPillarCol = 0;
        boolean isFoundPillar = false;


        for (int row = 0; row < size; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line[col];
                if (matrix[row][col] == 'S') {
                    rowMatrix = row;
                    colMatrix = col;
                }
                if (matrix[row][col] == 'P' && !isFoundPillar) {
                    firstPillarRow = row;
                    firstPillarCol = col;
                    isFoundPillar = true;
                }
                if (matrix[row][col] == 'P' && isFoundPillar) {
                    secondPillarRow = row;
                    secondPillarCol = col;
                }
            }
        }

        int sum = 0;


        while (sum < 50) {
            String command = scanner.nextLine();

            int oldRow = rowMatrix;
            int oldCol = colMatrix;

            switch (command) {
                case "up":
                    rowMatrix--;

                    break;

                case "down":
                    rowMatrix++;

                    break;

                case "right":
                    colMatrix++;

                    break;

                case "left":
                    colMatrix--;

                    break;
            }


            if (rowMatrix < 0 || rowMatrix >= size || colMatrix < 0 || colMatrix >= size) {
                matrix[oldRow][oldCol] = '-';
                break;
            }

            if (rowMatrix == firstPillarRow && colMatrix == firstPillarCol) {
                rowMatrix = secondPillarRow;
                colMatrix = secondPillarCol;
                matrix[firstPillarRow][firstPillarCol] = '-';


            } else if (rowMatrix == secondPillarRow && colMatrix == secondPillarCol) {
                rowMatrix = firstPillarRow;
                colMatrix = firstPillarCol;
                matrix[secondPillarRow][secondPillarCol] = '-';


            } else if (matrix[rowMatrix][colMatrix] == '-') {


            } else {
                sum += Character.getNumericValue (matrix[rowMatrix][colMatrix]);

            }

            matrix[oldRow][oldCol] = '-';
            matrix[rowMatrix][colMatrix] = 'S';

        }

        if (sum >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }

        System.out.println("Money: " + sum);

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
