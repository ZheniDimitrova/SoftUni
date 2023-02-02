package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Pattern patternMultiply = Pattern.compile("[0-9]");
        Matcher matcherMultiply = patternMultiply.matcher(input);

        String emojiRegex = "([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern patternEmoji = Pattern.compile(emojiRegex);
        Matcher matcherEmoji = patternEmoji.matcher(input);

        int coolThreshold = 1;

        while(matcherMultiply.find()){
            coolThreshold *= Integer.parseInt(matcherMultiply.group());
        }
        List<String> validEmojis = new ArrayList<>();
        int numberOfEmojis = 0;


        while (matcherEmoji.find()){
            String emojiName = matcherEmoji.group("emoji");
            numberOfEmojis++;
            int emojiCoolness = 0;

            for(char symbol : emojiName.toCharArray()){
                emojiCoolness += (int) symbol;

            }
            if (emojiCoolness >= coolThreshold){
                validEmojis.add(matcherEmoji.group());
            }
        }

        System.out.println("Cool threshold: " + coolThreshold);
        System.out.println( numberOfEmojis + " emojis found in the text. The cool ones are:");
        for (String emoji : validEmojis){
            System.out.println(emoji);
        }

    }
}
