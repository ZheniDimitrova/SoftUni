package fundamentalsSeptember2022_01Basic_LAB;

import java.util.Scanner;

public class SumOfOddNumbers_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int oddSum = 0;

        for (int i = 1; i <= number * 2 ; i++) {
            if (i % 2 != 0){
                System.out.println(i);
                oddSum += i;
            }
        }
        System.out.printf("Sum: %d", oddSum);
    }
}
