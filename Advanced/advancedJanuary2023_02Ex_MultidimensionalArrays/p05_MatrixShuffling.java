package advancedJanuary2023_02Ex_MultidimensionalArrays;

import java.util.Scanner;

public class p05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dimensions = scanner.nextLine();
        int rows = Integer.parseInt(dimensions.split("\\s+")[0]);
        int cols = Integer.parseInt(dimensions.split("\\s+")[1]);

        String[][] matrix = new String[rows][cols];

        fillTheMatrix(matrix, scanner);

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            if (isValidCommand(command, rows, cols)) {
                String[] commandParts = command.split("\\s+");

                int row1 = Integer.parseInt(commandParts[1]);
                int col1 = Integer.parseInt(commandParts[2]);
                int row2 = Integer.parseInt(commandParts[3]);
                int col2 = Integer.parseInt(commandParts[4]);

                String firstElem = matrix[row1][col1];
                String secondElem = matrix[row2][col2];
                matrix[row1][col1] = secondElem;
                matrix[row2][col2] = firstElem;

                printTheMatrix(matrix);

            } else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();
        }


    }

    public static void fillTheMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = scanner.next();
            }
            scanner.nextLine();
        }
    }

    public static boolean isValidCommand(String command, int rows, int cols) {

        String[] commandParts = command.split("\\s+");
        if (commandParts.length != 5) {
            return false;
        }
        if (!commandParts[0].equals("swap")) {
            return false;
        }
        int row1 = Integer.parseInt(commandParts[1]);
        int col1 = Integer.parseInt(commandParts[2]);
        int row2 = Integer.parseInt(commandParts[3]);
        int col2 = Integer.parseInt(commandParts[4]);

        if (row1 < 0 || row1 >= rows || row2 < 0 || row2 >= rows || col1 < 0 || col1 >= cols || col2 < 0 || col2 >= cols) {
            return false;
        }
        return true;
    }

    public static void printTheMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
