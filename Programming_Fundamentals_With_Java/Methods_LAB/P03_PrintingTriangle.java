package fundamentalsSeptember2022_04Methods_LAB;

import java.util.Scanner;

public class P03_PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        printTriangle(num);

    }

    public static void printTriangle(int number) {
        for (int rows = 1; rows <= number; rows++) {
            printLine(1, rows);
        }
        for (int i = number - 1; i >= 1; i--) {
            printLine(1, i);
        }
    }

    public static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}

