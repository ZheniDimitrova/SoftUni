package fundamentalsSeptember2022_05Lists_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int bombNumber = Integer.parseInt(scanner.next());
        int powerNumber = Integer.parseInt(scanner.next());

        while (numbersList.contains(bombNumber)) {
            int bombIndex = numbersList.indexOf(bombNumber);
            int start = bombIndex - powerNumber;
            int end = bombIndex + powerNumber;

            if (start < 0) {
                start = 0;
            }
            if (end > numbersList.size() - 1) {
                end = numbersList.size() - 1;
            }
            for (int i = start; i <= end; i++) {
                numbersList.remove(start);
            }
        }
        int sum = 0;
        for (Integer num : numbersList) {
            sum += num;
        }
        System.out.println(sum);
    }
}
