package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.Arrays;
import java.util.Scanner;

public class P02_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String[] commandInput = input.split("\\s+");

            switch (commandInput[0]) {
                case "swap":
                    int firstIndex = Integer.parseInt(commandInput[1]);
                    int secondIndex = Integer.parseInt(commandInput[2]);
                    int elem1 = numbersArray[firstIndex];
                    int elem2 = numbersArray[secondIndex];
                    numbersArray[firstIndex] = elem2;
                    numbersArray[secondIndex] = elem1;
                    break;

                case "multiply":
                    int index1 = Integer.parseInt(commandInput[1]);
                    int index2 = Integer.parseInt(commandInput[2]);
                    int multiplyElem1 = numbersArray[index1];
                    int multiplyElem2 = numbersArray[index2];
                    int result = multiplyElem1 * multiplyElem2;
                    numbersArray[index1] = result;
                    break;

                case "decrease":
                    for (int i = 0; i < numbersArray.length; i++) {
                        numbersArray[i]--;
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i < numbersArray.length; i++) {
            int currentNum = numbersArray[i];
            if (i < numbersArray.length - 1) {
                System.out.print(currentNum + ", ");
            } else {
                System.out.print(currentNum);
            }

        }

    }
}
