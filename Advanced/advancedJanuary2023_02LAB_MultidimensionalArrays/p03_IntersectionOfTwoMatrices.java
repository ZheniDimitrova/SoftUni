package advancedJanuary2023_02LAB_MultidimensionalArrays;

import java.util.Scanner;

public class p03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = new String[rows][cols];
        String[][] secondMatrix = new String[rows][cols];
        String[][] outputMatrix = new String[rows][cols];

        for (int rowFirst = 0; rowFirst < rows; rowFirst++) {
            String[] input = scanner.nextLine().split(" ");
            for (int colFirst = 0; colFirst < cols; colFirst++) {
                firstMatrix[rowFirst][colFirst] = input[colFirst];
            }
        }
        for (int rowSec = 0; rowSec < rows; rowSec++) {
            String[] inputSec = scanner.nextLine().split(" ");
            for (int colSec = 0; colSec < cols; colSec++) {
                secondMatrix[rowSec][colSec] = inputSec[colSec];
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    outputMatrix[row][col] = "*";
                } else {
                    outputMatrix[row][col] = firstMatrix[row][col];
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(outputMatrix[row][col] + " ");
            }
            System.out.println();
        }


    }
}

