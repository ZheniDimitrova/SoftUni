package Exam_Preparation;

import java.util.Scanner;

public class p02_StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];

        int rowDillinger = -1;
        int colDillinger = -1;

        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'D') {
                    rowDillinger = row;
                    colDillinger = col;
                }
            }
        }

        int stolenMoney = 0;
        boolean isCaught = false;

        for (int i = 0; i < commands.length; i++) {
            String direction = commands[i];

            int oldRol = rowDillinger;
            int oldCol = colDillinger;

            switch (direction) {

                case "up":
                    rowDillinger--;

                    break;

                case "down":
                    rowDillinger++;
                    break;

                case "right":
                    colDillinger++;
                    break;

                case "left":
                    colDillinger--;
                    break;
            }

            if (rowDillinger < 0 || rowDillinger >= size || colDillinger < 0 || colDillinger >= size) {
                rowDillinger = oldRol;
                colDillinger = oldCol;
                System.out.println("You cannot leave the town, there is police outside!");
            }
            if (matrix[rowDillinger][colDillinger] == '$') {
                int currentMoney = rowDillinger * colDillinger;
                stolenMoney += currentMoney;
                matrix[oldRol][oldCol] = '+';
                matrix[rowDillinger][colDillinger] = 'D';
                System.out.printf("You successfully stole %d$.%n", currentMoney);

            } else if (matrix[rowDillinger][colDillinger] == 'P') {
                matrix[oldRol][oldCol] = '+';
                matrix[rowDillinger][colDillinger] = '#';
                isCaught = true;

                break;

            } else if (matrix[rowDillinger][colDillinger] == '+'){
                matrix[oldRol][oldCol] = '+';
                matrix[rowDillinger][colDillinger] = 'D';
            }

        }
        if (isCaught) {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", stolenMoney);

        } else {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", stolenMoney);
        }

        printMatrix(matrix);

    }
    public static void printMatrix(char[][] matrix) {

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
