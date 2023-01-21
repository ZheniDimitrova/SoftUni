package fundamentalsSeptember2022_08TextProcessing_Exercises;

import java.util.Scanner;

public class P06_ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        char[] symbolArr = line.toCharArray();

        StringBuilder symbol = new StringBuilder();

        symbol.append(symbolArr[0]);
        for (int i = 1; i < symbolArr.length; i++) {
            char currentSymbol = symbolArr[i];
             if (currentSymbol != symbolArr[i - 1]){
                 symbol.append(currentSymbol);
             }
        }
        System.out.println(symbol);

    }
}
