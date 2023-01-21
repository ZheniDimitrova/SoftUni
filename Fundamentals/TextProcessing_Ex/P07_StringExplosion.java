package fundamentalsSeptember2022_08TextProcessing_Exercises;

import java.util.Scanner;

public class P07_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());
        int totalExplosion = 0;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '>') {
                int explosion = Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                totalExplosion += explosion;

            } else if (symbol != '>' && totalExplosion > 0) {
                input.deleteCharAt(i);
                totalExplosion--;
                i--;
            }
        }

        System.out.println(input);
    }
}
