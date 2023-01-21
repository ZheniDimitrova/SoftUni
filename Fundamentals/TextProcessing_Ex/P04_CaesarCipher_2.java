package fundamentalsSeptember2022_08TextProcessing_Exercises;

import java.util.Scanner;

public class P04_CaesarCipher_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StringBuilder encryptedText = new StringBuilder();

        for (char symbol : line.toCharArray()){
            encryptedText.append((char)(symbol + 3));

        }
        System.out.print(encryptedText);
    }
}
