package fundamentalsSeptember2022_09RegularExpressions_Exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P02_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> racerNamesList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        Map<String, Integer> racersMap = new LinkedHashMap<>();
        StringBuilder nameSb = new StringBuilder();
        int sumDistance = 0;

        for (int i = 0; i < racerNamesList.size(); i++) {
            String currentName = racerNamesList.get(i);
            racersMap.put(currentName, 0);
        }

        while (!input.equals("end of race")) {

            char[] code = input.toCharArray();

            for (char symbol : code) {
                if (Character.isLetter(symbol)) {
                    nameSb.append(symbol);
                } else if (Character.isDigit(symbol)) {
                    sumDistance += Integer.parseInt(symbol + "");
                }
            }
            if (racerNamesList.contains(nameSb.toString())) {
                int currentDistance = racersMap.get(nameSb.toString());
                racersMap.put(nameSb.toString(), sumDistance + currentDistance);
                nameSb.delete(0, nameSb.length());
                sumDistance = 0;

            } else {
                nameSb.delete(0, nameSb.length());
                sumDistance = 0;
            }

            input = scanner.nextLine();
        }
        List<String> top3Names = racersMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());

        System.out.println("1st place: " + top3Names.get(0));
        System.out.println("2nd place: " + top3Names.get(1));
        System.out.println("3rd place: " + top3Names.get(2));
    }
}
