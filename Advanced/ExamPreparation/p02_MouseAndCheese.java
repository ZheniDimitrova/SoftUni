package Exam_Preparation;

import java.util.Scanner;

public class p02_MouseAndCheese {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        int mouseRow = -1;
        int mouseCol = -1;

        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        String command = scanner.nextLine();
        int cheese = 0;

        while (!command.equals("end")) {

            matrix[mouseRow][mouseCol] = '-';
            switch (command) {

                case "up":
                    mouseRow--;

                    break;

                case "down":
                    mouseRow++;
                    break;

                case "right":
                    mouseCol++;
                    break;

                case "left":
                    mouseCol--;
                    break;
            }

            if (mouseRow < 0 || mouseRow >= size || mouseCol < 0 || mouseCol >= size) {
                System.out.println("Where is the mouse?");
                break;
            }

            if (matrix[mouseRow][mouseCol] == 'c') {
                cheese++;

            } else if (matrix[mouseRow][mouseCol] == 'B') {
                continue;

            }
            matrix[mouseRow][mouseCol] = 'M';

            command = scanner.nextLine();
        }

        if (cheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        }

        printMatrix(matrix);

    }
    public static  void printMatrix(char[][] matrix){

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

}
