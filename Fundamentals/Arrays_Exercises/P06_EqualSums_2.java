package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P06_EqualSums_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < numbersArr.length; i++) {
            int currentNum = numbersArr[i];
            int leftSum = 0;
            int rightSum = 0;

            if (numbersArr.length == 1) {
                System.out.println(0);
                return;
            }

            for (int leftI = 0; leftI < i; leftI++) {
                int leftNum = numbersArr[leftI];
                leftSum += leftNum;
            }
            for (int rightI = i + 1; rightI < numbersArr.length; rightI++) {
                int rightNum = numbersArr[rightI];
                rightSum += rightNum;
            }
            if (leftSum == rightSum) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("no");
    }
}
