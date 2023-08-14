package fundamentalsSeptember2022_08TextProcessing_LAB;

import java.util.Scanner;

public class P03_Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordToRemove = scanner.nextLine();
        String text = scanner.nextLine();

        while (text.contains(wordToRemove)) {
            text = text.replace(wordToRemove, "");

        }
        System.out.println(text);
    }
}

