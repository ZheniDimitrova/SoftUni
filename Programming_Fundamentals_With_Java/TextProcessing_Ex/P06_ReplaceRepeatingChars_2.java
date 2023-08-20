package fundamentalsSeptember2022_08TextProcessing_Exercises;

import java.util.Scanner;

public class P06_ReplaceRepeatingChars_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder symbolsLine = new StringBuilder(scanner.nextLine());

        for (int i = 0; i < symbolsLine.length() - 1; i++) {
            if (symbolsLine.charAt(i) == symbolsLine.charAt(i + 1)) {
                symbolsLine.deleteCharAt(i + 1);
                i--;
            }
        }
        System.out.println(symbolsLine);
    }
}
