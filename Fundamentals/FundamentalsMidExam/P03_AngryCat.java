package fundamentalsSeptember2022_MidExam_Oct23;

import java.util.Arrays;
import java.util.Scanner;

public class P03_AngryCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pricesArr = Arrays.stream(scanner.nextLine()
                        .split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int entryIndex = Integer.parseInt(scanner.nextLine());
        String typeOfItems = scanner.nextLine();

        int leftSum = 0;
        int rightSum = 0;

        for (int index = entryIndex +1; index <= pricesArr.length - 1; index++) {

            if (typeOfItems.equals("cheap")){
                if (pricesArr[index]  < pricesArr[entryIndex]){
                    rightSum += pricesArr[index];
            }
            } else if(typeOfItems.equals("expensive")){
                if (pricesArr[entryIndex]  <= pricesArr[index]){
                    rightSum += pricesArr[index];
                }
            }
        }
        for (int index = entryIndex-1; index >= 0; index--) {
            if (typeOfItems.equals("cheap")){
                if (pricesArr[index]  < pricesArr[entryIndex]){
                    leftSum += pricesArr[index];
                }
            } else if(typeOfItems.equals("expensive")){
                if (pricesArr[entryIndex]  <= pricesArr[index]){
                    leftSum += pricesArr[index];
                }
            }
        }

        if (rightSum > leftSum){
            System.out.printf("Right - %d%n", rightSum);
        } else if (rightSum < leftSum){
            System.out.printf("Left - %d%n", leftSum);
        } else {
            System.out.printf("Left - %d%n", leftSum);
        }

    }
}
