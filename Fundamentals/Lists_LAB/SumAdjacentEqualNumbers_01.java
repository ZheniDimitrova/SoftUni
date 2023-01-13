package List_LAB;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {
            double firstElement = numbers.get(i);
            double secondElement = numbers.get(i + 1);

            if (firstElement == secondElement) {
                numbers.set(i, (numbers.get(i) + numbers.get(i + 1)));
                numbers.remove(i+1);
                i = -1;

            }


        }
        System.out.println(joinElementByDelimiter(numbers, " "));
    }
     public static String joinElementByDelimiter (List<Double>list, String delimiter){
        String result = "";
        for (Double num : list){
            DecimalFormat df = new DecimalFormat("0.#");
            String numFormat = df.format(num) + delimiter;
            result += numFormat;
        }
        return  result;
     }
}
