package fundamentalsSeptember2022_07AssociativeArraysLambdaStreamAPI_Exercises;

import java.util.*;

public class P05_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> coursesMap = new LinkedHashMap<>();

        while (!input.equals("end")) {
            String[] namesArr = input.split(" : ");
            String course = namesArr[0];
            String studentName = namesArr[1];

            if (!coursesMap.containsKey(course)) {
                coursesMap.put(course, new ArrayList<>());
                coursesMap.get(course).add(studentName);
            } else {
                coursesMap.get(course).add(studentName);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : coursesMap.entrySet()) {
            String courseName = entry.getKey();
            List<String> studentsList = entry.getValue();

            System.out.printf("%s: %d%n", courseName, studentsList.size());
            for (String student : studentsList) {
                System.out.printf("-- %s%n", student);
            }
        }
    }
}
