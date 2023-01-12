package fundamentalsSeptember2022_04Methods_Exercises;


import java.util.Scanner;

public class P02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        printVowelsCount(input);
    }

    public static void printVowelsCount(String text) {
        int vowelsCount = 0;

        for (int index = 1; index <= text.length() - 1; index++) {
            char currentSymbol = text.charAt(index);

            if (currentSymbol == 'a' || currentSymbol == 'o' || currentSymbol == 'e' || currentSymbol == 'i' || currentSymbol == 'u') {
                vowelsCount++;
            }
        }
        System.out.println(vowelsCount);

    }
}
