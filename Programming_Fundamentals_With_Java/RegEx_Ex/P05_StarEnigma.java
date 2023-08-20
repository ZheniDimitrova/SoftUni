package fundamentalsSeptember2022_09RegularExpressions_Exercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05_StarEnigma {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfMessages = Integer.parseInt(scanner.nextLine());

        String regex = "[starSTAR]";
        Pattern pattern = Pattern.compile(regex);
        String planetRegex = "@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:(?<population>[0-9]+)[^@\\-!:>]*!(?<type>[AD])![^@\\-!:>]*->(?<soldiersCount>[0-9]+)";
        Pattern planetPattern = Pattern.compile(planetRegex);
        List<String> destroyedPlanets = new ArrayList<>();
        List<String> attackedPlanets = new ArrayList<>();

        for (int i = 1; i <= numOfMessages ; i++) {
            String encryptMessage = scanner.nextLine();
            Matcher matcher = pattern.matcher(encryptMessage);
            int specialLetters =  (int)matcher.results().count();
            String decryptMessage = "";

            for (char symbol : encryptMessage.toCharArray()){
                char newSymbol =  (char) (symbol - specialLetters);
                decryptMessage += newSymbol;
            }

            Matcher planetMatcher = planetPattern.matcher(decryptMessage);


            while(planetMatcher.find()){
                String planet = planetMatcher.group("planetName");
                String attackType = planetMatcher.group("type");


                if (attackType.equals("A")){
                    attackedPlanets.add(planet);
                } else {
                    destroyedPlanets.add(planet);
                }

            }
            Collections.sort(attackedPlanets);
            Collections.sort(destroyedPlanets);
        }
            System.out.printf("Attacked planets: %d%n", attackedPlanets.size());
            for (String name : attackedPlanets){
                System.out.printf("-> %s%n",name);
            }

            System.out.printf("Destroyed planets: %d%n", destroyedPlanets.size());
            for (String name : destroyedPlanets){
                System.out.printf("-> %s%n",name);
            }

    }
}
