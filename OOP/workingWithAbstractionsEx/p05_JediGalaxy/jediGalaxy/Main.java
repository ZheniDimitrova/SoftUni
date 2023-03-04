package workingWithAbstractionsEx.p05_JediGalaxy.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int rows = dimensions[0];
            int cols = dimensions[1];

            int[][] matrix = new int[rows][cols];

            int value = 0;
            for (int i = 0; i < rows; i++)
            {
                for (int j = 0; j < cols; j++)

                {
                    matrix[i][j] = value++;
                }
            }
            String command = scanner.nextLine();
            long sum = 0;
            while (!command.equals("Let the Force be with you")) {

                int[] playerCoordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
                int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

                int evilRow = evilCoordinates[0];
                int evilCol = evilCoordinates[1];

                moveEvil(matrix, evilRow, evilCol);

                int playerRow = playerCoordinates[0];
                int playerCol = playerCoordinates[1];

                sum = movePlayer(matrix, sum, playerRow, playerCol);

                command = scanner.nextLine();
            }

        System.out.println(sum);


    }

    private static void moveEvil(int[][] matrix, int evilRow, int evilCol) {
        while (evilRow >= 0 && evilCol >= 0) {

            if (evilRow >= 0 && evilRow < matrix.length && evilCol >= 0 && evilCol < matrix[0].length) {
                matrix[evilRow] [evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static long movePlayer(int[][] matrix, long sum, int playerRow, int playerCol) {
        while (playerRow >= 0 && playerCol < matrix[1].length) {
            if (playerRow >= 0 && playerRow < matrix.length && playerCol >= 0 && playerCol < matrix[0].length)
            {
                sum += matrix[playerRow][playerCol];
            }

            playerCol++;
            playerRow--;
        }
        return sum;
    }
}
