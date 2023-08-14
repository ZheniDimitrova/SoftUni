package advancedJanuary2023_02Ex_MultidimensionalArrays;

import java.util.Scanner;

public class p04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        fillTheMatrix(matrix, scanner);

        int maxSum3x3 = Integer.MIN_VALUE;
        int maxIndexRow = -1;
        int maxIndexCol = -1;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > maxSum3x3) {
                    maxSum3x3 = currentSum;
                    maxIndexRow = row;
                    maxIndexCol = col;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum3x3);
        System.out.println(matrix[maxIndexRow][maxIndexCol] + " " + matrix[maxIndexRow][maxIndexCol + 1] + " " + matrix[maxIndexRow][maxIndexCol + 2]);
        System.out.println(matrix[maxIndexRow + 1][maxIndexCol] + " " + matrix[maxIndexRow + 1][maxIndexCol + 1] + " " + matrix[maxIndexRow + 1][maxIndexCol + 2]);
        System.out.println(matrix[maxIndexRow + 2][maxIndexCol] + " " + matrix[maxIndexRow + 2][maxIndexCol + 1] + " " + matrix[maxIndexRow + 2][maxIndexCol + 2]);


    }

    public static void fillTheMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }
    }
}
