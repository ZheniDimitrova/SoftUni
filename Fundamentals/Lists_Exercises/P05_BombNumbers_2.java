package fundamentalsSeptember2022_05Lists_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_BombNumbers_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int bomb = Integer.parseInt(scanner.next());
        int power = Integer.parseInt(scanner.next());

        while (numbersList.contains(bomb)) {
            int bombIndex = numbersList.indexOf(bomb);
            int start = Math.max(bombIndex - power, 0);
            int end = Math.min(bombIndex + power, numbersList.size() - 1);

            for (int i = start; i <= end; i++) {
                numbersList.remove(start);

            }
        }
        int sum = 0;
        for (Integer element : numbersList) {
            sum += element;
        }
        System.out.println(sum);
    }

}

