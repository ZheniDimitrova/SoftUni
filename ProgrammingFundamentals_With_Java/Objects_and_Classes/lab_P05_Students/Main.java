package lab_P05_Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student> studentList = new ArrayList<>();

        while (!input.equals("end")) {
            String[] studentsData = input.split(" ");

            String firstName = studentsData[0];
            String lastName = studentsData[1];
            int age = Integer.parseInt(studentsData[2]);
            String town = studentsData[3];

            Student student = new Student(firstName, lastName, age, town);
            studentList.add(student);

            input = scanner.nextLine();
        }
        String cityInput = scanner.nextLine();

        for (Student student : studentList)
            if (student.getHomeTown().equals(cityInput)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
    }
}

