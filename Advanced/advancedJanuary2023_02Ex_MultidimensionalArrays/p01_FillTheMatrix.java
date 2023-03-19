package advancedJanuary2023_02Ex_MultidimensionalArrays;

import java.util.Scanner;

public class p01_FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int size = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[size][size];

        if (pattern.equals("A")) {
            fillMatrixPatternA(matrix);
        } else {
            fillMatrixPatternB(matrix);
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }


    }

    public static void fillMatrixPatternA(int[][] matrix) {
        int start = 1;

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][col] = start;
                start++;
            }
        }
    }

    public static void fillMatrixPatternB(int[][] matrix) {
        int start = 1;

        for (int col = 0; col < matrix.length; col++) {
            if (col % 2 == 0) { //четен индекс(0, 2, 4..), нечетна позиция(1-ва колона, 3-та...)
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][col] = start;
                    start++;
                }
            } else { //нечетен индекс (1, 3, 5..), четна позиция(втора колона, 4-та..)
                for (int row = matrix.length - 1; row >= 0; row--) {
                    matrix[row][col] = start;
                    start++;
                }
            }
        }
    }

}

