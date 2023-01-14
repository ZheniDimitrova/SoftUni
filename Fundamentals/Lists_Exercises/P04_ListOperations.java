package fundamentalsSeptember2022_05Lists_Exercises;

import com.sun.management.HotSpotDiagnosticMXBean;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("End")) {
            if (command.contains("Add")) {
                int numberToAdd = Integer.parseInt(command.split("\\s+")[1]);
                numbersList.add(numberToAdd);

            } else if (command.contains("Insert")) {
                int numberToInsert = Integer.parseInt(command.split("\\s+")[1]);
                int indexToInsert = Integer.parseInt(command.split("\\s+")[2]);
                if (isValidIndex(indexToInsert, numbersList)) {
                    numbersList.add(indexToInsert, numberToInsert);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Remove")) {
                int indexToRemove = Integer.parseInt(command.split("\\s+")[1]);
                if (isValidIndex(indexToRemove, numbersList)) {
                    numbersList.remove(indexToRemove);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Shift left")) {
                int shiftLeftTimes = Integer.parseInt(command.split("\\s+")[2]);
                for (int i = 0; i < shiftLeftTimes; i++) {
                    int firstNum = numbersList.get(0);
                    numbersList.remove(0);
                    numbersList.add(firstNum);
                }

            } else if (command.contains("Shift right")) {
                int shiftRightTimes = Integer.parseInt(command.split("\\s+")[2]);
                for (int i = 0; i < shiftRightTimes; i++) {
                    int lastNum = numbersList.get(numbersList.size() - 1);
                    numbersList.remove(numbersList.size() - 1);
                    numbersList.add(0, lastNum);
                }
            }
            command = scanner.nextLine();
        }
        System.out.print(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }

    public static boolean isValidIndex(int index, List<Integer> numbers) {
        return index >= 0 && index <= numbers.size() - 1;
    }
}

