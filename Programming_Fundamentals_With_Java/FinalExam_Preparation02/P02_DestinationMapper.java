package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String placesOnTheMap = scanner.nextLine();
        String regex = "(=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(placesOnTheMap);
        int totalLength = 0;
        List<String> placesList = new ArrayList<>();

        while(matcher.find()){
            String place = matcher.group("destination");
            totalLength += place.length();
            placesList.add(place);
        }

        System.out.println("Destinations: " + String.join(", ", placesList));
        System.out.println("Travel Points: " + totalLength);
    }
}

