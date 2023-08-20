package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.*;
import java.util.stream.Collectors;

public class P03_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> topNumbersList = new ArrayList<>();
        List<Integer> top5 = new ArrayList<>();

        int sumOfNumbers = 0;

        int maxNum = Integer.MIN_VALUE;
        int maxIndex = -1;

        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < numbersList.size(); i++) {
                int number = numbersList.get(i);
                if (number > maxNum && !top5. contains(i)){
                    maxNum = number;
                    maxIndex = i;
                }
        }
            top5.add(maxIndex);
            maxNum = Integer.MIN_VALUE;

        }

        for (int i = 0; i < numbersList.size(); i++) {
            sumOfNumbers += numbersList.get(i);
        }

        for (int num = 0; num < top5.size(); num++) {
            int currentNumber = numbersList.get(top5.get(num));
            int average = sumOfNumbers / numbersList.size();

            if (currentNumber > average) {
                topNumbersList.add(currentNumber);
            }
        }
        if (topNumbersList.isEmpty()){
            System.out.println("No");
        }
        for (int element : topNumbersList) {
            System.out.print(element + " ");
        }
    }
}
