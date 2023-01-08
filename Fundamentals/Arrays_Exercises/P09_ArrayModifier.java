package fundamentalsSeptember2022_03Arrays_Exercises;

import java.lang.module.FindException;
import java.util.Arrays;
import java.util.Scanner;

public class P09_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String command = scanner.nextLine();

        while (!command.equals("end")){

                if (command.contains("swap")){
                    int firstIndex = Integer.parseInt(command.split(" ")[1]);
                    int secondIndex = Integer.parseInt(command.split(" ")[2]);
                    int firstElem = numbersArray[firstIndex];
                    int secondElem = numbersArray[secondIndex];
                    numbersArray[firstIndex] = secondElem;
                    numbersArray[secondIndex] = firstElem;

                } else if (command.contains("multiply")){
                    int firstIndex = Integer.parseInt(command.split(" ")[1]);
                    int secondIndex = Integer.parseInt(command.split(" ")[2]);
                    int firstElem = numbersArray[firstIndex];
                    int secondElem = numbersArray[secondIndex];
                    int multiplyResult = firstElem * secondElem;
                   numbersArray[firstIndex] = multiplyResult;


                } else if (command.equals("decrease")){
                    for (int index = 0; index <= numbersArray.length - 1 ; index++) {
                        numbersArray[index]--;


                    }
                }
            command = scanner.nextLine();
            }
        for (int index = 0; index <= numbersArray.length -1; index++) {
            int currentNum = numbersArray[index];

            if (index != numbersArray.length -1){
                System.out.print(currentNum + ", ");
            } else{
                System.out.print(currentNum);
            }

        }

        }
    }

