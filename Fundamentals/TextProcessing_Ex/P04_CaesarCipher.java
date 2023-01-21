package fundamentalsSeptember2022_08TextProcessing_Exercises;

import java.util.Scanner;

public class P04_CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        for (char symbol : line.toCharArray()){
            System.out.print((char) (symbol + 3));
        }
    }
}
