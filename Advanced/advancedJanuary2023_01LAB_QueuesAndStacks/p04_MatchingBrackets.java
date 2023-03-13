package advancedJanuary2023_01LAB_QueuesAndStacks;

import java.util.ArrayDeque;
import java.util.Scanner;

public class p04_MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque <Integer> partsDeque = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '('){
                partsDeque.push(i);
            } else if (symbol == ')'){
                System.out.println(input.substring(partsDeque.pop(),i +1));
            }

        }
    }
}
