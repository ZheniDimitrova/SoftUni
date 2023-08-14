package fundamentalsSeptember2022_08TextProcessing_LAB;

import java.util.Scanner;

public class P02_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsArr = scanner.nextLine().split(" ");

        StringBuilder repeatWords = new StringBuilder();

        for (String word : wordsArr){
            int count = word.length();

            for (int i = 0; i < count; i++) {
                repeatWords.append(word);
            }
        }
        System.out.println(repeatWords);
    }
}
