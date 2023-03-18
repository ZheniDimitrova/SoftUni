package advancedJanuary2023_02LAB_MultidimensionalArrays;

import java.util.Scanner;

public class p06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (row == col) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
        }
        System.out.println();
        for (int row = size - 1; row >= 0; row--) {
            for (int col = 0; col < size; col++) {
                if (row + col == matrix.length - 1) {
                    System.out.print(matrix[row][col] + " ");
                }
            }

        }
    }
}
