package fundamentalsSeptember2022_04Methods_LAB;

import java.io.SyncFailedException;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class P01_SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        printSignIntegers(number);
    }

    public static void printSignIntegers(int num) {
        if (num > 0) {
            System.out.printf("The number %d is positive.", num);
        } else if (num < 0) {
            System.out.printf("The number %d is negative.", num);
        } else if (num == 0) {
            System.out.println("The number 0 is zero.");
        }

    }
}
