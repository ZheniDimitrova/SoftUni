package advancedJanuary2023_03LAB_SetsAndMaps;

import java.util.*;

public class p08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> namesAndScoresMap = new TreeMap<>();



        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] studentsScores = scanner.nextLine().split("\\s+");
            if (!namesAndScoresMap.containsKey(name)){
                namesAndScoresMap.put(name, new ArrayList<>());
            }
            for (int j = 0; j < studentsScores.length; j++) {
                double currentScore = Double.parseDouble(studentsScores[j]);
                namesAndScoresMap.get(name).add(currentScore);
            }
        }
            for (Map.Entry<String, List<Double>> entry : namesAndScoresMap.entrySet()) {
                String studentName = entry.getKey();
                double sum = 0;
                for (double grade : entry.getValue()){
                    sum += grade;
                }
                double avg = sum/entry.getValue().size();
                System.out.printf("%s is graduated with %s%n", studentName, avg);
            }

    }
}
