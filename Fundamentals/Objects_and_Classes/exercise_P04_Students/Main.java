package exercise_P04_Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        List<Students> studentsList = new ArrayList<>();

        for (int i = 1; i <= num ; i++) {
            String[] studentInfo = scanner.nextLine().split(" ");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            double grade = Double.parseDouble(studentInfo[2]);

            Students currentStudent = new Students(firstName, lastName, grade);
            studentsList.add(currentStudent);
        }
        studentsList.sort(Comparator.comparing(Students::getGrade).reversed());

        for( Students student : studentsList){
            System.out.println(student);
        }
    }
}
