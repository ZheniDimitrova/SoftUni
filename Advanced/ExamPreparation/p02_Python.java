package Exam_Preparation;

import java.util.Scanner;

public class p02_Python {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        char[][] screenMatrix = new char[size][size];
        int pythonRow = -1;
        int pythonCol = -1;


        int totalFood = 0;

        for (int row = 0; row < size; row++) {
            char[] line = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
            for (int col = 0; col < size; col++) {
                screenMatrix[row][col] = line[col];
                if (screenMatrix[row][col] == 's') {
                    pythonRow = row;
                    pythonCol = col;
                }
                if (screenMatrix[row][col] == 'f') {
                    totalFood++;
                }
            }

        }
        int pythonLength = 1;
        boolean isKilled = false;
        boolean isAllFoodEaten = false;

        for (String command : commands) {

            screenMatrix[pythonRow][pythonCol] = '*';

            switch (command) {

                case "up":
                    pythonRow--;
                    if (pythonRow < 0){
                        pythonRow = size -1;
                    }
                    break;

                case "down":
                    pythonRow++;
                    if (pythonRow >= size){
                        pythonRow = 0;
                    }
                    break;

                case "right":
                    pythonCol++;
                    if (pythonCol >= size){
                        pythonCol = 0;
                    }
                    break;

                case "left":
                    pythonCol--;
                    if (pythonCol < 0){
                        pythonCol = size -1;
                    }
                    break;
            }
            if (screenMatrix[pythonRow][pythonCol] == 'e'){
                isKilled = true;
                break;

            } else if (screenMatrix[pythonRow][pythonCol] == 'f'){
                pythonLength++;
                totalFood--;

                if (totalFood == 0){
                    isAllFoodEaten = true;
                    break;
                }
            }
            screenMatrix[pythonRow][pythonCol] = 's';

        }
        if (isAllFoodEaten){
            System.out.printf("You win! Final python length is %d", pythonLength);
        } else if (isKilled){
            System.out.println("You lose! Killed by an enemy!");
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.", totalFood);
        }

    }
}
