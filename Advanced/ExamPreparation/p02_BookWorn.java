package Exam_Preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class p02_BookWorn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[] string = scanner.nextLine().toCharArray();
        int size = Integer.parseInt(scanner.nextLine());

        List<Character> modifierString = new ArrayList<>();
        for (char ch : string) {
            modifierString.add(ch);
        }

        char[][] matrix = new char[size][size];
        int playerRow = -1;
        int playerCol = -1;

        for (int row = 0; row < size; row++) {
            char[] line = scanner.nextLine().replaceAll(" ", "").toCharArray();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line[col];
                if (matrix[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        String command = scanner.nextLine();

        while(!command.equals("end")){

            int oldRow = playerRow;
            int oldCol = playerCol;

            switch (command) {

                case "up":
                    playerRow--;

                    break;

                case "down":
                    playerRow++;
                    break;

                case "right":
                    playerCol++;
                    break;

                case "left":
                    playerCol--;
                    break;
            }

            if (playerRow < 0 || playerRow >= size || playerCol < 0 || playerCol >= size) {
                if (!modifierString.isEmpty()) {
                    modifierString.remove(modifierString.size() - 1);
                }
                matrix[oldRow][oldCol] = 'P';
                playerRow = oldRow;
                playerCol = oldCol;


            }   else {

                if (Character.isLetter(matrix[playerRow][playerCol])) {
                    modifierString.add((char)matrix[playerRow][playerCol]);
                    matrix[oldRow][oldCol] = '-';
                    matrix[playerRow][playerCol] = 'P';

                }else if (matrix[playerRow][playerCol] == '-'){
                    matrix[oldRow][oldCol] = '-';
                    matrix[playerRow][playerCol] = 'P';

                }
            }

            command = scanner.nextLine();
        }

        for (char ch : modifierString){
            System.out.print(ch);
        }
        System.out.println();
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