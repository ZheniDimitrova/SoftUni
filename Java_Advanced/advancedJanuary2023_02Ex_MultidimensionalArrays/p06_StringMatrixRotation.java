package advancedJanuary2023_02Ex_MultidimensionalArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p06_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String rotate = scanner.nextLine();
        int angleRotation = (Integer.parseInt(rotate.split("[()]+")[1]) % 360)/90;
        String input = scanner.nextLine();
        List<String> list = new ArrayList<>();
        int max = -1;
        while (!input.equals("END")) {
            list.add(input);
            if(input.length() > max) max = input.length();
            input = scanner.nextLine();
        }
        char[][] matrix = new char[list.size()][];

        for (int row = 0; row < list.size(); row++) {
            char[] maxWord = new char[max];
            char[] word = list.get(row).toCharArray();
            for (int col = 0; col < maxWord.length; col++) {
                if(col < word.length)maxWord[col] = word[col];
                else maxWord[col] = ' ';
            }
            matrix[row] = maxWord;
        }

        for(int i = 0; i < angleRotation; i++) {
            matrix = rotate90(matrix);
        }
        printMatrix(matrix);
    }

    public static char[][] rotate90(char[][] matrix){
        char[][] rotatedMatrix = new char[matrix[0].length][matrix.length];
        int col = 0;
        for(int i = matrix.length-1; i >= 0; i--) {
            for(int j = 0; j < matrix[0].length; j++) {
                rotatedMatrix[j][col] = matrix[i][j];
            }
            col++;
        }
        return rotatedMatrix;
    }
    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
               System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
