package Exam_Preparation;

import java.util.Scanner;

public class p02_ReVolt {

    static int matrixRow = -1;
    static int matrixCol = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine().trim());

        int commandsCount = Integer.parseInt(scanner.nextLine().trim());

        char[][] matrix = new char[size][size];


        for (int row = 0; row < size; row++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line[col];
                if (matrix[row][col] == 'f') {
                    matrixRow = row;
                    matrixCol = col;
                    matrix[row][col] = '-';
                }
            }

        }
        boolean isWon = false;
        for (int i = 0; i < commandsCount; i++) {
            String command = scanner.nextLine();
            movePlayer(matrix, command);

            if (matrix[matrixRow][matrixCol] == 'F') {
                isWon = true;
                System.out.println("Player won!");
                break;

            }

        }
        matrix[matrixRow][matrixCol] = 'f';
        if (!isWon){
            System.out.println("Player lost!");
        }

        printMatrix(matrix);


    }
     public static void movePlayer(char[][] matrix, String command) {

        int currentRow = matrixRow;
        int currentCol = matrixCol;

         switch (command) {
             case "up": {
                 matrixRow--;
                 if (matrixRow < 0) {
                     matrixRow = matrix.length - 1;
                 }
             }
             break;

             case "down": {
                 matrixRow++;
                 if (matrixRow > matrix.length - 1) {
                     matrixRow = 0;
                 }
             }
                 break;

             case "left": {
                 matrixCol--;
                 if (matrixCol < 0) {
                     matrixCol = matrix.length - 1;
                 }
             }
                 break;

             case "right": {
                 matrixCol++;
                 if (matrixCol > matrix.length - 1) {
                     matrixCol = 0;
                 }
             }
                 break;
         }
         if (matrix[matrixRow][matrixCol] == 'T'){
            matrixRow = currentRow;
            matrixCol = currentCol;
         }
         else if (matrix[matrixRow][matrixCol] == 'B'){
             movePlayer(matrix, command);
         }
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
