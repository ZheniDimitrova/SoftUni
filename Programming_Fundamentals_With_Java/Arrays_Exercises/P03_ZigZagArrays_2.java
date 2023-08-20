package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Scanner;

public class P03_ZigZagArrays_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] firstArray = new String[n];
        String[] secondArray = new String[n];

        for (int index = 0; index < n; index++) {
            String[] numbersInput = scanner.nextLine().split(" ");
            String firstNumber = numbersInput[0];
            String secondNumber = numbersInput[1];

            if (index % 2 != 0) {
                firstArray[index] = secondNumber;
                secondArray[index] = firstNumber;
            } else {
                firstArray[index] = firstNumber;
                secondArray[index] =secondNumber;
            }
        }
        for (String firstElement : firstArray){
            System.out.print(firstElement + " ");
        }
        System.out.println();
        for (String secondElem : secondArray)
        System.out.print(secondElem + " " );
    }
}
