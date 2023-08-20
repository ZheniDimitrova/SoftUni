package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05_TopInteger_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();


        for (int i = 0; i < numbersArray.length; i++) {
            int currentNum = numbersArray[i];
            if (i == numbersArray.length - 1) {
                System.out.print(currentNum);
                break;
            }
            boolean isTopInteger = false;

            for (int j = i + 1; j <= numbersArray.length - 1; j++) {
                int nextNum = numbersArray[j];
                if (currentNum > nextNum) {
                    isTopInteger = true;
                } else {
                    isTopInteger = false;
                    break;
                }
            }
            if (isTopInteger) {
                System.out.print(currentNum + " ");
            }
        }

    }
}
