package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P08_MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int magicNumber = Integer.parseInt(scanner.nextLine());

        for (int index = 0; index <= numbers.length - 1; index++) {
            int currentNum = numbers[index];
            for (int secondIndex = index + 1; secondIndex <= numbers.length - 1; secondIndex++) {
                int nextNum = numbers[secondIndex];

                if (currentNum + nextNum == magicNumber){
                  System.out.printf("%d %d%n", currentNum, nextNum);
                }

            }

        }

    }
}
