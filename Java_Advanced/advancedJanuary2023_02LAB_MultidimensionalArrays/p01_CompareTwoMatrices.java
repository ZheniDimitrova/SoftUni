package advancedJanuary2023_02LAB_MultidimensionalArrays;

import java.util.Scanner;

public class p01_CompareTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndColsFirst = scanner.nextLine().split(" ");
        int rowsFirst = Integer.parseInt(rowsAndColsFirst[0]);
        int colsFirst = Integer.parseInt(rowsAndColsFirst[1]);

        int[][] firstMatrix = new int[rowsFirst][colsFirst];

        for (int row = 0; row < rowsFirst; row++) {
            String[] inputFirst = scanner.nextLine().split(" ");
            for (int col = 0; col < colsFirst; col++) {
                firstMatrix[row][col] = Integer.parseInt(inputFirst[col]);

            }

        }

        String[] rowsAndColsSecond = scanner.nextLine().split(" ");
        int rowsSecond = Integer.parseInt(rowsAndColsSecond[0]);
        int colsSecond = Integer.parseInt(rowsAndColsSecond[1]);

        int[][] secondMatrix = new int[rowsSecond][colsSecond];

        for (int row = 0; row < rowsSecond; row++) {
            String[] inputSecond = scanner.nextLine().split(" ");

            for (int col = 0; col < colsSecond; col++) {
                secondMatrix[row][col] = Integer.parseInt(inputSecond[col]);
            }
        }

        if (rowsFirst != rowsSecond || colsFirst != colsSecond) {
            System.out.println("not equal");
            return;
        }
        boolean areEqual = true;
        for (int row = 0; row < rowsFirst; row++) {
            for (int col = 0; col < colsFirst; col++) {

                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    areEqual = false;
                    break;
                }


            }

        }

        if (areEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }


    }
}
