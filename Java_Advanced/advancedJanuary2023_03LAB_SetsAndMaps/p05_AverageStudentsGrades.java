package advancedJanuary2023_03LAB_SetsAndMaps;

import java.util.*;

public class p05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsMap = new TreeMap<>();

        for (int i = 0; i < number; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String name = info[0];
            double grade = Double.parseDouble(info[1]);

            if (!studentsMap.containsKey(name)) {
                studentsMap.put(name, new ArrayList<>());
            }
            studentsMap.get(name).add(grade);

        }
        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            String name = entry.getKey();
            System.out.print(name + " -> ");
            double sum = 0;
            for (double element : entry.getValue()) {
                sum += element;
                System.out.printf("%.2f ", element);

            }
            double average = sum / entry.getValue().size();
            System.out.printf("(avg: %.2f)%n", average);

        }

    }
}
