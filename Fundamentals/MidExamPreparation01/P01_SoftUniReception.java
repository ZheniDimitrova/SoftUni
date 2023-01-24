package fundamentalsSeptember2022_MidExam_Preparation;

import javax.swing.*;
import java.util.Scanner;

public class P01_SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int studentsPerHour = firstEmployee + secondEmployee + thirdEmployee;
        double workingHours = Math.ceil(studentsCount * 1.0 / studentsPerHour);
        double EmployeeBreaks = 0;
        double totalTime = 0;

        for (int hour = 0; hour < workingHours; hour++) {
            if (hour % 3 == 0) {
                EmployeeBreaks++;
            }
            totalTime = hour + EmployeeBreaks;

        }

        System.out.printf("Time needed: %.0fh.", totalTime);
    }
}
