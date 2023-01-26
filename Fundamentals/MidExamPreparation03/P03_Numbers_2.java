package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.*;
import java.util.stream.Collectors;

public class P03_Numbers_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> topNumbers = new ArrayList<>();
        int sum = 0;
        for (int num = 0; num < numbersList.size(); num++) {
            sum += numbersList.get(num);
        }
        double average = sum * 1.0 / numbersList.size();

        for (int i = 0; i < numbersList.size(); i++) {
            int currentNum = numbersList.get(i);

            if (currentNum > average){
                topNumbers.add(currentNum);
            }
        }
        Collections.sort(topNumbers);
        Collections.reverse(topNumbers);

        if (topNumbers.size() > 5){
            for (int i = 0; i < 5; i++) {
                System.out.print(topNumbers.get(i) + " ");
            }
        } else if (topNumbers.isEmpty()){
            System.out.println("No");
        } else {
            for (int element : topNumbers){
                System.out.print(element + " ");
            }
        }
    }
}
