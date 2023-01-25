package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.Arrays;
import java.util.Scanner;

public class P02_ArrayModifier_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String commandInput = scanner.nextLine();

        while (!commandInput.equals("end")) {
            String[] command = commandInput.split(" ");

            switch (command[0]) {
                case "swap":
                    int index1 = Integer.parseInt(command[1]);
                    int index2 = Integer.parseInt(command[2]);
                    int firstEl = numbersArray[index1];
                    int secondEl = numbersArray[index2];
                    numbersArray[index1] = secondEl;
                    numbersArray[index2] = firstEl;

                    break;

                case "multiply":
                    int firstIndex = Integer.parseInt(command[1]);
                    int secondIndex = Integer.parseInt(command[2]);
                    int elem1 = numbersArray[firstIndex];
                    int elem2 = numbersArray[secondIndex];
                    int result = elem1 * elem2;
                    numbersArray[firstIndex] = result;
                    break;

                case "decrease":
                    for (int i = 0; i < numbersArray.length; i++) {
                        numbersArray[i]--;
                    }
                    break;
            }
            commandInput = scanner.nextLine();
        }
        for (int i = 0; i < numbersArray.length; i++) {
            int currentElement = numbersArray[i];
            if (i < numbersArray.length - 1) {
                System.out.print(currentElement + ", ");
            } else {
                System.out.print(currentElement);
            }

        }

    }
}



