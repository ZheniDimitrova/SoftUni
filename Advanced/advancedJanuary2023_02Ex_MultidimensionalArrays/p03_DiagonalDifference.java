package advancedJanuary2023_02Ex_MultidimensionalArrays;

import java.util.Scanner;

public class p03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[size][size];

        fillTheMatrix(matrix, scanner);

        int sumPrimary = sumPrimaryDiagonal(matrix);
        int sumSecondary = sumSecondaryDiagonal(matrix);
        int difference = Math.abs(sumPrimary - sumSecondary);
        System.out.println(difference);
    }

    public static int sumPrimaryDiagonal(int[][] matrix) {

        int primarySum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++)
                if (row == col) {
                    primarySum += matrix[row][col];
                }
        }
        return primarySum;
    }


    public static int sumSecondaryDiagonal(int[][] matrix) {

        int secondarySum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                if (row + col == matrix.length - 1) {
                    secondarySum += matrix[row][col];
                }
            }
        }
        return secondarySum;
    }

    public static void fillTheMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}