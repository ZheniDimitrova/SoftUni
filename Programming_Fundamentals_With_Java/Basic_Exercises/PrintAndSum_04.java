package fundamentalsSeptember2022_01Basic_Exercises;

import java.util.Scanner;

public class PrintAndSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNUmber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());
        int sum =0;

        for (int i = firstNUmber; i <= endNumber ; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println();
        System.out.printf("Sum: %d", sum);

    }
}
