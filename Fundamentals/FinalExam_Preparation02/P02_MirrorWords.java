package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "(#|@)(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);

        List<String> pairsList = new ArrayList<>();
        int allPairsCount = 0;

        while(matcher.find()){
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            allPairsCount++;

            StringBuilder secondWordSb = new StringBuilder(secondWord);
            String reversedWord = secondWordSb.reverse().toString();

            if (firstWord.equals(reversedWord)){
                pairsList.add(firstWord + " <=> " + secondWord);
            }
        }

        if (allPairsCount == 0 ){
            System.out.println("No word pairs found!");
        } else {
            System.out.println(allPairsCount + " word pairs found!");
        }

        if (pairsList.size() == 0){
            System.out.println("No mirror words!");
        } else {
            System.out.println("The mirror words are:");
            System.out.println(String.join(", ", pairsList));
        }


    }
}
