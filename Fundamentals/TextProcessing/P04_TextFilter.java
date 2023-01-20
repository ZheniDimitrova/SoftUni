package fundamentalsSeptember2022_08TextProcessing_LAB;

import java.util.Scanner;

public class P04_TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] bannedWords = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String banWord:bannedWords){
            int count = banWord.length();
            text = text.replace(banWord, repeatString("*", count));
        }
        System.out.println(text);
    }
    public static String repeatString (String s, int count){
        StringBuilder repeatedStr = new StringBuilder();
        for (int i = 0; i < count; i++) {
            repeatedStr.append(s);
        }
        return repeatedStr.toString();
    }
}
