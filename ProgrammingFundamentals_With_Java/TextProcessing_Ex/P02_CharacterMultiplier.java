package fundamentalsSeptember2022_08TextProcessing_Exercises;

import java.util.Scanner;

public class P02_CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        char[] firstText = input[0].toCharArray();
        char[] secondText = input[1].toCharArray();

        int maxTextLength = Math.max(firstText.length, secondText.length);
        int minTextLength = Math.min(firstText.length, secondText.length);
        int sum = 0;

        for (int i = 0; i < maxTextLength; i++) {
            if (i < minTextLength){
                sum += firstText[i] * secondText[i];
            } else if (firstText.length > secondText.length){
                sum += firstText[i];
            } else {
                sum += secondText[i];
            }
        }
        System.out.println(sum);
    }
}
