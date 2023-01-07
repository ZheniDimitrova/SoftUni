package fundamentalsSeptember2022_03Arrays_LAB;

import java.util.Arrays;
import java.util.Scanner;

public class P05_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int evenSum = 0;
        int oddSum = 0;

        for (int elements : numbersArr) {
            if (elements % 2 == 0){
                evenSum += elements;
            }else{
                oddSum += elements;
            }

        }
        System.out.println(evenSum - oddSum);

    }
}
