package advancedJanuary2023_01Ex_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class p01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(" ");
        ArrayDeque<String> stuckOfNumbers = new ArrayDeque<>();

        for (int i = 0; i < numbers.length ; i++) {
            stuckOfNumbers.push(numbers[i]);
        }

        for (String num : stuckOfNumbers){
            System.out.print(num + " ");
        }

    }
}
