package Exam_Preparation;

import java.util.Scanner;

public class p02_Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrixBakery = new char[size][size];

        int matrixRow = -1;
        int matrixCol = -1;
        int firstPillarRow = 0;
        int firstPillarCol = 0;
        int secondPillarRow = 0;
        int secondPillarCol = 0;
        boolean pillarIsFound = false;

        for (int row = 0; row < size; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                matrixBakery[row][col] = line[col];

                if (matrixBakery[row][col] == 'S') {
                    matrixRow = row;
                    matrixCol = col;
                }
                if (matrixBakery[row][col] == 'O' && !pillarIsFound) {
                    firstPillarRow = row;
                    firstPillarCol = col;
                    pillarIsFound = true;

                }

                if (matrixBakery[row][col] == 'O' && pillarIsFound) {
                    secondPillarRow = row;
                    secondPillarCol = col;
                }
            }
        }
        int money = 0;

        while (money < 50) {

            String command = scanner.nextLine();

            int prevRow = matrixRow;
            int prevCol = matrixCol;

            switch (command) {
                case "up":
                    matrixRow--;

                    break;

                case "down":
                    matrixRow++;

                    break;

                case "right":
                    matrixCol++;

                    break;

                case "left":
                    matrixCol--;
                    break;
            }

            if (matrixRow < 0 || matrixRow >= size || matrixCol < 0 || matrixCol >= size) {
                matrixBakery[prevRow][prevCol] = '-';
                break;
            }

            if (matrixRow == firstPillarRow && matrixCol == firstPillarCol){
                matrixRow = secondPillarRow;
                matrixCol = secondPillarCol;
                matrixBakery[firstPillarRow][firstPillarCol] = '-';


            } else if (matrixRow == secondPillarRow && matrixCol == secondPillarCol) {
                matrixRow = firstPillarRow;
                matrixCol = firstPillarCol;
                matrixBakery[secondPillarRow][secondPillarCol] = '-';

            }  else if (Character.isDigit(matrixBakery[matrixRow][matrixCol])) {
                money += Character.getNumericValue(matrixBakery[matrixRow][matrixCol]);

            } else if (matrixBakery[matrixRow][matrixCol] == '-' ){

            }

            matrixBakery[prevRow][prevCol] = '-';
            matrixBakery[matrixRow][matrixCol] = 'S';
        }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news, you are out of the bakery.");
        }
        System.out.println("Money: " + money);

        printMatrix(matrixBakery);


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
