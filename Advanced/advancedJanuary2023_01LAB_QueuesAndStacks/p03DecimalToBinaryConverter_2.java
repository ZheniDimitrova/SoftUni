package advancedJanuary2023_01LAB_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p03DecimalToBinaryConverter_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        ArrayDeque <Integer> binary = new ArrayDeque<>();

        if (number == 0){
            System.out.println(0);
        }

        while (number > 0){
            int reminder = number % 2;
            binary.push(reminder);
            number /= 2;
        }
        for (int num : binary){
            System.out.print(num);
        }

    }
}
