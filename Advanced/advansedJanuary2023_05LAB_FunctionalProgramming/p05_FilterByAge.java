package advansedJanuary2023_05LAB_FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class p05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> peopleMap = new LinkedHashMap<>();

        int peopleCount = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < peopleCount; i++) {
            String[] info = scanner.nextLine().split(", ");
            String name = info[0];
            int age = Integer.parseInt(info[1]);

            peopleMap.put(name, age);
        }
        String comparison = scanner.nextLine();
        int ageLimit = Integer.parseInt(scanner.nextLine());
        String printType = scanner.nextLine();

        BiPredicate<Integer, Integer> filterAge;

        if (comparison.equals("younger")) {
            filterAge = (age, age2) -> age <= age2;
        } else {
            filterAge = (age, age2) -> age >= age2;
        }

        Consumer<Map.Entry<String, Integer>> printer;
        if (printType.equals("age")) {
            printer = map -> System.out.println(map.getValue());
        } else if (printType.equals("name")) {
            printer = map -> System.out.println(map.getKey());
        } else {
            printer = map -> System.out.printf("%s - %d%n", map.getKey(), map.getValue());
        }

        peopleMap.entrySet().stream()
                .filter(person -> filterAge.test(person.getValue(), ageLimit))
                .forEach(printer);
    }
}
