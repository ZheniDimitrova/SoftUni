package fundamentalsSeptember2022_09RegularExpressions_LAB;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "\\+359([- ])2\\1[0-9]{3}\\1[0-9]{4}\\b";
        String phoneNumbers = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumbers);

        List<String> sofiaNumbers = new ArrayList<>();
        while(matcher.find()){
            sofiaNumbers.add(matcher.group());
        }
        System.out.println(String.join(", ", sofiaNumbers));
    }
}
