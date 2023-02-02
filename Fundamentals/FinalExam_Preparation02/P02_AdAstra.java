package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        String regex = "(#|\\|)(?<itemName>[A-Za-z\\s]+)\\1(?<expirationDate>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<calories>[0-9]{1,5})\\1";
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(text);
        int totalKcal = 0;
        int days = 0;
        StringBuilder foodInfo = new StringBuilder();

        while (matcher.find()){
            String itemName = matcher.group("itemName");
            String expDate = matcher.group("expirationDate");
            int kcal = Integer.parseInt(matcher.group("calories"));

            totalKcal += kcal;
            days = totalKcal / 2000;

            foodInfo.append(String.format("Item: %s, Best before: %s, Nutrition: %d%n", itemName, expDate, kcal));

        }
        System.out.printf("You have food to last you for: %d days!%n", days);
        System.out.println(foodInfo);


    }
}
