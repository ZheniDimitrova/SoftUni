package fundamentalsSeptember2022_09RegularExpressions_Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02_Race_Regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participantList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        Map <String, Integer> racersMap = new LinkedHashMap<>();

        for (int i = 0; i < participantList.size(); i++) {
            String participant = participantList.get(i);
            racersMap.put(participant, 0);
        }

        String regexLetters = "[A-Za-z]+";
        Pattern pattern = Pattern.compile(regexLetters);

        String regexDigits = "[0-9]";
        Pattern pattern1 = Pattern.compile(regexDigits);


        String info = scanner.nextLine();
        while (!info.equals("end of race")) {

            StringBuilder racersSb = new StringBuilder();
            Matcher matcherLetter = pattern.matcher(info);

            while(matcherLetter.find()){
                racersSb.append(matcherLetter.group());
            }
            int distance = 0;
            Matcher matcherDigits = pattern1.matcher(info);
            while(matcherDigits.find()){
                distance += Integer.parseInt(matcherDigits.group());
            }

            if (participantList.contains(racersSb.toString())){
                int currentDistance = racersMap.get(racersSb.toString());
                racersMap.put(racersSb.toString(), distance + currentDistance);
            }

            info = scanner.nextLine();
        }

        List<String> top3 = racersMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("1st place: " + top3.get(0));
        System.out.println("2nd place: " + top3.get(1));
        System.out.println("3rd place: " + top3.get(2));
    }
}

