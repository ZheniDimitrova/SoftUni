package p03_opinionPoll;

import p03_opinionPoll.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> personsList = new ArrayList<>();
        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= num ; i++) {
            String input = scanner.nextLine();

            String name = input.split(" ")[0];
            int age = Integer.parseInt(input.split(" ")[1]);
            if (age > 30){
                Person person = new Person(name, age);
                personsList.add(person);
            }
        }

        for(Person person : personsList){
            System.out.println(person.getName() + " - " + person.getAge());
        }


    }
}
