package fundamentalsSeptember2022_03Arrays_LAB;

import java.util.Arrays;
import java.util.Scanner;

public class P07_CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] condensedArr = new int[numbersArr.length - 1];

        for (int i = 0; i < numbersArr.length; i++) {
            if (numbersArr.length == 1){
                break;
            }
            if (i == numbersArr.length - 1){
                numbersArr = condensedArr;
                condensedArr = new int[numbersArr.length - 1];
                i = -1;
            } else{
                int num = numbersArr[i] + numbersArr[i+1];
                condensedArr[i] = num;
            }

        }
        System.out.println(numbersArr[0]);
    }
}
