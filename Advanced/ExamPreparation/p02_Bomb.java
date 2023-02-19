package Exam_Preparation;

import java.util.Scanner;

public class p02_Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split(",");

        char[][] matrix = new char[size][size];
        int sapperRow = -1;
        int sapperCol = -1;
        int allBombsInField = 0;
        int bombCount = 0;

        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int col = 0; col < size; col++) {
                if (matrix[row][col] == 's') {
                    sapperRow = row;
                    sapperCol = col;
                }
                if (matrix[row][col] == 'B') {
                    allBombsInField++;
                }

            }
        }
        boolean isEnd = false;

        for (int i = 0; i < input.length; i++) {
            String direction = input[i];

            int oldRow = sapperRow;
            int oldCol = sapperCol;

            switch (direction) {
                case "up":
                    sapperRow--;

                    break;

                case "down":
                    sapperRow++;

                    break;

                case "right":
                    sapperCol++;

                    break;

                case "left":
                    sapperCol--;

                    break;
            }
            if (sapperRow < 0 || sapperRow >= size || sapperCol < 0 || sapperCol >= size) {
                sapperRow = oldRow;
                sapperCol = oldCol;
            }
            if (matrix[sapperRow][sapperCol] == 'B') {
                bombCount++;
                matrix[oldRow][oldCol] = '+';
                matrix[sapperRow][sapperCol] = '+';
                System.out.println("You found a bomb!");


            } else if (matrix[sapperRow][sapperCol] == 'e') {
                matrix[oldRow][oldCol] = '+';
                matrix[sapperRow][sapperCol] = 's';
                isEnd = true;
                break;

            } else if (matrix[sapperRow][sapperCol] == '+') {
                matrix[oldRow][oldCol] = '+';
                matrix[sapperRow][sapperCol] = 's';

            }

        }
        if (bombCount == allBombsInField) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (isEnd) {
            System.out.printf("END! %d bombs left on the field%n", allBombsInField - bombCount);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", allBombsInField - bombCount, sapperRow, sapperCol);
        }

    }
}
