package advancedJanuary2023_02LAB_MultidimensionalArrays;

import java.util.Scanner;

public class p02_PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] rowOfMatrix = scanner.nextLine().split(" ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(rowOfMatrix[col]);
            }
        }

        int number = Integer.parseInt(scanner.nextLine());
        boolean foundNumber = false;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols ; col++) {

                if (matrix[row][col] == number){
                    foundNumber = true;
                    System.out.printf("%d %d%n", row, col);
                }
            }
        }
        if (!foundNumber){
            System.out.println("not found");
        }
    }
}
