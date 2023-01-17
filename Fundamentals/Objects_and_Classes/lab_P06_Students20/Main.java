package lab_P06_Students20;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student20> studentList = new ArrayList<>();

        while (!input.equals("end")) {
            String[] studentsData = input.split(" ");

            String firstName = studentsData[0];
            String lastName = studentsData[1];
            int age = Integer.parseInt(studentsData[2]);
            String town = studentsData[3];

            Student20 student = new Student20(firstName, lastName, age, town);

            boolean isFound = false;
            for (Student20 eachStudent : studentList) {
                if (eachStudent.getFirstName().equals(firstName) && eachStudent.getLastName().equals(lastName)) {
                    eachStudent.setTown(town);
                    eachStudent.setAge(age);
                    isFound = true;
                    break;
                }

            }
            if (!isFound) {
                studentList.add(student);
            }

            input = scanner.nextLine();
        }
        String cityInput = scanner.nextLine();

        for (Student20 student : studentList)
            if (student.getTown().equals(cityInput)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());
            }
    }
}
