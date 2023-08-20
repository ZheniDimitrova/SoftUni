package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.Arrays;
import java.util.Scanner;

public class P02_ShotForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targetNumbers = Arrays.stream(scanner.nextLine()
                        .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        String input = scanner.nextLine();
        int totalShotNumbers = 0;

        while (!input.equals("End")) {
            int commandIndex = Integer.parseInt(input);
            if (commandIndex < 0 || commandIndex > targetNumbers.length - 1) {
                input = scanner.nextLine();
                continue;
            }
            int shotNumber = targetNumbers[commandIndex];
            if (shotNumber != -1) {
                totalShotNumbers++;
                targetNumbers[commandIndex] = -1;
            }

            for (int i = 0; i < targetNumbers.length; i++) {
                if (targetNumbers[i] != -1) {
                    if (targetNumbers[i] > shotNumber) {
                        targetNumbers[i] -= shotNumber;
                    } else {
                        targetNumbers[i] += shotNumber;
                    }
                }
            }

            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d -> ", totalShotNumbers);
        for (int shotNum : targetNumbers){
            System.out.print(shotNum + " ");
        }

    }
}
