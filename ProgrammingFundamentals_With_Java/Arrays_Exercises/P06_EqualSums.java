package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P06_EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int leftSum = 0;
        int rightSum = 0;

        for (int index = 0; index <= numbers.length - 1 ; index++) {

            if (numbers.length == 1){
                System.out.println(0);
                return;
            }

            for (int leftIndex = index - 1; leftIndex >= 0; leftIndex--) {
                int leftNum = numbers[leftIndex];
                leftSum += leftNum;
            }
            for (int rightIndex = index + 1; rightIndex <= numbers.length - 1 ; rightIndex++) {
                int rightNum = numbers[rightIndex];
                rightSum += rightNum;
            }
            if (leftSum == rightSum){
                System.out.println(index);
                return;
            } else {
                leftSum = 0;
                rightSum = 0;
            }

        }
        System.out.println("no");

    }
}
