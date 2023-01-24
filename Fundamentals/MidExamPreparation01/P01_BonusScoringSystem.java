package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.Scanner;

public class P01_BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int numberOfLectures = Integer.parseInt(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());
        double maxBonus = Double.MIN_VALUE;
        int maxStudent = 0;

        for (int student = 1; student <= numberOfStudents; student++) {
            int studentAttendance = Integer.parseInt(scanner.nextLine());


            double totalBonus = Math.ceil(studentAttendance * 1.00 / numberOfLectures * (5 + bonus));
            if (totalBonus >= maxBonus) {
                maxBonus = totalBonus;
                maxStudent = studentAttendance;
            }
        }
        System.out.printf("Max Bonus: %.0f.%n", maxBonus);
        System.out.printf("The student has attended %d lectures.", maxStudent);
    }
}
