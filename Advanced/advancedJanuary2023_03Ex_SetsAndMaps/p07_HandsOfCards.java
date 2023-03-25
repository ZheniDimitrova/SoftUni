package advancedJanuary2023_03Ex_SetsAndMaps;

import java.util.*;

public class p07_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Set<String>> playersMap = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String name = input.split(":\\s+")[0];
            String cards = input.split(":\\s+")[1];
            String[] cardsInfo = cards.split(", ");

            Set<String> cardsSet = new LinkedHashSet<>(Arrays.asList(cardsInfo));

            if (!playersMap.containsKey(name)) {
                playersMap.put(name, cardsSet);
            } else {
                playersMap.get(name).addAll(Arrays.asList(cardsInfo));
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : playersMap.entrySet()) {
            String name = entry.getKey();
            int result = 0;
            for (String currentCard : entry.getValue()) {
               result += getSumCard(currentCard);


            }
            System.out.printf("%s: %d%n", name, result);

        }

    }

    public static int getSumCard(String card) {
        int power = 0;
        int multiplier = 0;
        String value = card.substring(0, card.length() - 1);
        char type = card.charAt(card.length() - 1);
        switch (value) {
            case "J":
                power = 11;
                break;
            case "Q":
                power = 12;
                break;
            case "K":
                power = 13;
                break;
            case "A":
                power = 14;
                break;
            default:
                power = Integer.parseInt(value);

        }
        switch (type) {
            case 'S':
                multiplier = 4;
                break;
            case 'H':
                multiplier = 3;
                break;
            case 'D':
                multiplier = 2;
                break;
            case 'C':
                multiplier = 1;
                break;
        }
            return power * multiplier;
    }
}
