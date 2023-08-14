package advancedJanuary2023_02LAB_MultidimensionalArrays;

import java.util.Scanner;

public class p05_MaxSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }

        }

        int maxSum = Integer.MIN_VALUE;
        int maxIndexRow = -1;
        int maxIndexCol = -1;

        for (int row = 0; row < rows-1; row++) {
            for (int col = 0; col < cols-1; col++) {
                int currentSum = matrix[row][col] + matrix[row+1][col] + matrix[row][col + 1] + matrix[row + 1][col + 1];
                if (currentSum > maxSum){
                    maxSum = currentSum;
                    maxIndexRow = row;
                    maxIndexCol = col;
                }
            }

        }
        System.out.println(matrix[maxIndexRow][maxIndexCol]+ " " + matrix[maxIndexRow][maxIndexCol + 1]);
        System.out.println(matrix[maxIndexRow +1][maxIndexCol]+ " " + matrix[maxIndexRow +1][maxIndexCol + 1]);
        System.out.println(maxSum);


    }
}
