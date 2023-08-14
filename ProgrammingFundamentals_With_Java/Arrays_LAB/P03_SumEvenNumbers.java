package fundamentalsSeptember2022_03Arrays_LAB;

import java.util.Arrays;
import java.util.Scanner;

public class P03_SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] inputNumbersArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sum = 0;

        for (int i = 0; i < inputNumbersArr.length; i++) {
            if (inputNumbersArr[i] % 2 == 0) {
                sum += inputNumbersArr[i];
            }
        }
        System.out.printf("%d", sum);
    }
}
