package fundamentalsSeptember2022_05Lists_Exercises;

import javax.imageio.metadata.IIOMetadataFormatImpl;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P10_SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("course start")) {
            String[] commandInput = input.split(":");
            String lessonTitle = commandInput[1];

            switch (commandInput[0]) {
                case "Add":
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                    }
                    break;

                case "Insert":
                    int indexLesson = Integer.parseInt(commandInput[2]);
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(indexLesson, lessonTitle);
                    }
                    break;

                case "Remove":
                    String exercise = lessonTitle + "-Exercise";
                    schedule.remove(lessonTitle);
                    schedule.remove(exercise);
                    break;

                case "Swap":
                    String lessonToSwap = commandInput[2];
                    String exOfLessonTitle = lessonTitle + "-Exercise";
                    String exOfLessonToSwap = lessonToSwap + "-Exercise";


                    if (schedule.contains(lessonTitle) && schedule.contains(lessonToSwap)) {
                        int indexOfLessonTitle = schedule.indexOf(lessonTitle);
                        int indexOfLessonToSwap = schedule.indexOf(lessonToSwap);
                        Collections.swap(schedule, indexOfLessonTitle, indexOfLessonToSwap);
                    }
                    if (schedule.contains(exOfLessonTitle)) {
                        schedule.remove(exOfLessonTitle);
                        schedule.add(schedule.indexOf(lessonTitle) + 1, exOfLessonTitle);
                    }
                    if (schedule.contains(exOfLessonToSwap)) {
                        schedule.remove(exOfLessonToSwap);
                        schedule.add(schedule.indexOf(lessonToSwap) + 1, exOfLessonToSwap);
                    }
                    break;
                case "Exercise":
                    if (schedule.contains(lessonTitle) && !schedule.contains(lessonTitle + "-Exercise")) {
                        schedule.add(schedule.indexOf(lessonTitle) + 1, lessonTitle + "-Exercise");
                    } else if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                        schedule.add(lessonTitle + "-Exercise");

                    }

                    break;
            }
            input = scanner.nextLine();
        }

        for (int i = 1; i <= schedule.size(); i++) {
            System.out.println(i + "." + schedule.get(i - 1));
        }

    }
}

