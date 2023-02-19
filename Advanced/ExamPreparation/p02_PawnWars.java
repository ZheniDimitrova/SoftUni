package Exam_Preparation;

import java.util.Scanner;

public class p02_PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessMatrix = new char[8][8];

        int wRow = -1;
        int wCol = -1;
        int bRow = -1;
        int bCol = -1;

         boolean whiteIsHit = false;
         boolean blackIsHit = false;

        for (int row = 0; row < chessMatrix.length; row++) {
            chessMatrix[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < chessMatrix.length; col++) {
                if (chessMatrix[row][col] == 'w') {
                    wRow = row;
                    wCol = col;
                }
                if (chessMatrix[row][col] == 'b') {
                    bRow = row;
                    bCol = col;
                }

            }
        }

        while (wRow != 0 && bRow != chessMatrix.length - 1) {

            if (wRow - 1 == bRow && (wCol + 1 == bCol || wCol - 1 == bCol)) {
                blackIsHit = true;
                break;
            }

            wRow--;

            if (bRow + 1 == wRow && (bCol + 1 == wCol || bCol - 1 == wCol)) {
                whiteIsHit = true;
                break;
            }

            bRow++;

        }

        String coordinatesBlack = findCoordinates(bCol, bRow);
        String coordinatesWhite = findCoordinates(wCol, wRow);

        if (!blackIsHit && !whiteIsHit) {
            if (wRow == 0) {
                System.out.printf("Game over! White pawn is promoted to a queen at %s.%n", coordinatesWhite);

            } else {
                System.out.printf("Game over! Black pawn is promoted to a queen at %s.%n", coordinatesBlack);
            }

        }
        if (blackIsHit) {

            System.out.printf("Game over! White capture on %s.", coordinatesBlack);

        } else if (whiteIsHit) {

            System.out.printf("Game over! Black capture on %s.", coordinatesWhite);
        }


    }
    private static String findCoordinates(int c, int r) {
        char[] col = new char[] {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = new char[] {'8', '7', '6', '5', '4', '3', '2', '1'};


       return String.valueOf(col[c]) + row[r];
    }
}
