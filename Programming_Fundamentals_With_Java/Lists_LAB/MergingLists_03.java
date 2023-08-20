package List_LAB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer ::parseInt).collect(Collectors.toList());

        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer ::parseInt).collect(Collectors.toList());

        List<Integer> resultList = new ArrayList<>();
    }
}
