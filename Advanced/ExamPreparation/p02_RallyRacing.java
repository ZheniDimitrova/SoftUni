package Exam_Preparation;

import java.util.Scanner;

public class p02_RallyRacing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        char[][] matrix = new char[size][size];

        int racerRow = 0;
        int racerCol = 0;
        int firstTunnelRow = -1;
        int firstTunnelCol = -1;
        int secondTunnelRow = -1;
        int secondTunnelCol = -1;
        boolean isTunnel = false;

        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int col = 0; col < size; col++) {

                if (matrix[row][col] == 'T' && !isTunnel) {
                    firstTunnelRow = row;
                    firstTunnelCol = col;
                    isTunnel = true;

                }
                 if (matrix[row][col] == 'T' && isTunnel) {
                    secondTunnelRow = row;
                    secondTunnelCol = col;
                }

                 if (racerRow == row && racerCol == col) {
                     matrix[row][col] = 'C';
                 }

            }
        }

        String command = scanner.nextLine();

        int passedKm = 0;
        boolean isFinished = false;

        while(!command.equals("End")) {


            int oldRol = racerRow;
            int oldCol = racerCol;

            switch (command) {
                case "up":
                    racerRow--;

                    break;

                case "down":
                    racerRow++;

                    break;

                case "right":
                    racerCol++;

                    break;

                case "left":
                    racerCol--;

                    break;

            }

            if (racerRow == firstTunnelRow && racerCol == firstTunnelCol) {
                racerRow = secondTunnelRow;
                racerCol = secondTunnelCol;
                passedKm += 30;
                matrix[oldRol][oldCol] = '.';
                matrix[firstTunnelRow][firstTunnelCol] = '.';
                matrix[racerRow][racerCol] = 'C';



            } else if (racerRow == secondTunnelRow && racerCol == secondTunnelCol) {
                racerRow = firstTunnelRow;
                racerCol = firstTunnelCol;
                passedKm += 30;
                matrix[oldRol][oldCol] = '.';
                matrix[secondTunnelCol][secondTunnelRow] = '.';
                matrix[racerRow][racerCol] = 'C';


            } else if (matrix[racerRow][racerCol] == 'F') {
                passedKm += 10;
                matrix[oldRol][oldCol] = '.';
                matrix[racerRow][racerCol] = 'C';
                isFinished = true;
                break;

            } else if (matrix[racerRow][racerCol] == '.') {
                passedKm += 10;
                matrix[oldRol][oldCol] = '.';
                matrix[racerRow][racerCol] = 'C';
            }

            command = scanner.nextLine();
        }

        if (isFinished) {
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);

        } else {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }

        System.out.printf("Distance covered %d km.%n", passedKm);

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
