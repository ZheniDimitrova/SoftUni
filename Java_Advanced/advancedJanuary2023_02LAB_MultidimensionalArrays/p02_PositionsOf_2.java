package advancedJanuary2023_02LAB_MultidimensionalArrays;

import java.util.Scanner;

public class p02_PositionsOf_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }

        int number = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int currentNum = matrix[row][col];

                if (currentNum == number) {
                    isFound = true;
                    System.out.printf("%d %d%n", row, col);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
