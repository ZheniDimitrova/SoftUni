package advancedJanuary2023_06Ex_DefiningClasses.p01_OpinionPoll;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> personsList = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);

            Person person = new Person(name, age);
            personsList.add(person);

           personsList = personsList.stream().filter(person1 -> person1.getAge() > 30).collect(Collectors.toList());
           personsList.sort(Comparator.comparing(p -> p.getName()));

        }

        for (Person person : personsList){
            System.out.println(String.format("%s - %d", person.getName(), person.getAge()));
        }



    }
}
