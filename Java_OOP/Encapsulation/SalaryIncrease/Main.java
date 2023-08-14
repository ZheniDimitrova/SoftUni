package Encapsulation.SalaryIncrease;

import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < people; i++) {
            String[] input = scanner.nextLine().split(" ");

            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            personList.add(new Person(firstName, lastName, age, salary));
        }

        double bonus = Double.parseDouble(scanner.nextLine());

        for (Person person : personList) {
            person.increaseSalary(bonus);
            System.out.println(person);
        }


    }
}
