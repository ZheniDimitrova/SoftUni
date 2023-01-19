package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI_Exercises;

import java.util.*;

public class P06_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsMap = new LinkedHashMap<>();

        for (int student = 1; student <= n; student++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentsMap.containsKey(name)) {
                studentsMap.put(name, new ArrayList<>());
            }
            studentsMap.get(name).add(grade);
        }
        Map<String, Double> averageGradeMap = new LinkedHashMap<>();

        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            String name = entry.getKey();
            List<Double> gradesList = entry.getValue();
            double averageGrade = getAverageGrade(gradesList);

            if (averageGrade >= 4.50){
                averageGradeMap.put(name, averageGrade);
            }
        }
        for (Map.Entry<String, Double> entry : averageGradeMap.entrySet()) {
            System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
        }


    }

    public static double getAverageGrade(List<Double> ListGrades) {
        double sumGrades = 0;

        for (double grade : ListGrades) {
            sumGrades += grade;
        }
        return sumGrades / ListGrades.size();
    }
}
