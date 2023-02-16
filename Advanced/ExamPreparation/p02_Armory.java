package Exam_Preparation;

import java.util.Scanner;

public class p02_Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] armoryMatrix = new char[size][size];
        int rowArmory = -1;
        int colArmory = -1;
        int firstMirrorRow = 0;
        int firstMirrorCol = 0;
        int secondMirrorRow = 0;
        int secondMirrorCol = 0;
        boolean isMirrorFound = false;

        for (int r = 0; r < size; r++) {
            char[] line = scanner.nextLine().toCharArray();
            for (int c = 0; c < size; c++) {
                armoryMatrix[r][c] = line[c];
                if (armoryMatrix[r][c] == 'A'){
                    rowArmory = r;
                    colArmory = c;
                }
                if (armoryMatrix[r][c] == 'M' && !isMirrorFound) {
                    firstMirrorRow = r;
                    firstMirrorCol = c;
                    isMirrorFound = true;
                }
                if (armoryMatrix[r][c] == 'M' && isMirrorFound) {
                    secondMirrorRow = r;
                    secondMirrorCol = c;
                }
            }
        }

        int money = 0;

        while(money < 65){

            String command = scanner.nextLine();
            int oldRow = rowArmory;
            int oldCol = colArmory;


            switch (command){

                case "up":
                    rowArmory--;

                    break;

                case "down":
                    rowArmory++;
                    break;

                case "right":
                    colArmory++;
                    break;

                case "left":
                    colArmory--;
                    break;

            }

            if (rowArmory < 0 || rowArmory >= size || colArmory < 0 || colArmory >= size){
                armoryMatrix[oldRow][oldCol] = '-';
                break;
            }
            if (rowArmory == firstMirrorRow && colArmory == firstMirrorCol){
                rowArmory = secondMirrorRow;
                colArmory = secondMirrorCol;
                armoryMatrix[firstMirrorRow][firstMirrorCol] = '-';

            } else if (rowArmory == secondMirrorRow && colArmory == secondMirrorCol){
                rowArmory = firstMirrorRow;
                colArmory = firstMirrorCol;
                armoryMatrix[secondMirrorRow][secondMirrorCol] = '-';

            } else if (Character.isDigit(armoryMatrix[rowArmory][colArmory])){
                money += Character.getNumericValue(armoryMatrix[rowArmory][colArmory]);
            }

            armoryMatrix[oldRow][oldCol] = '-';
            armoryMatrix[rowArmory][colArmory] = 'A';
        }

        if (money >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        } else {
            System.out.println("I do not need more swords!");
        }

        System.out.printf("The king paid %d gold coins.%n", money);

        printMatrix(armoryMatrix);


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
