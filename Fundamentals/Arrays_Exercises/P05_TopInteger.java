package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05_TopInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i <= numbersArr.length -1; i++) {
            int currentNum = numbersArr[i];

            if (i == numbersArr.length -1){
                System.out.print(currentNum + " ");
                break;
            }
            boolean isTop = false;
            for (int j = i + 1; j <= numbersArr.length - 1 ; j++) {
                int nextNum = numbersArr[j];

                if (currentNum > nextNum){
                    isTop = true;
                }else{
                    isTop = false;
                    break;
                }
            }
            if (isTop){
                System.out.print(currentNum + " ");
            }
        }

    }
}
