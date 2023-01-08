package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Scanner;

public class P03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());

        String[] firstArr = new String [input];
        String[] secondArr = new String [input];

        for (int i = 1; i <= input; i++) {
            String[] numbersInput = scanner.nextLine().split(" ");
            String firstNumber = numbersInput[0];
            String secondNumber = numbersInput[1];

            if (i % 2 != 0){
                firstArr[i - 1] = firstNumber;
                secondArr[i - 1] = secondNumber;
            } else {
                firstArr[i - 1] = secondNumber;
                secondArr[i - 1] = firstNumber;
            }
        }
        for (String elem:firstArr) {
            System.out.print(elem + " ");
        }
        System.out.println();
        for(String elements:secondArr)
            System.out.print(elements + " ");



    }
}
