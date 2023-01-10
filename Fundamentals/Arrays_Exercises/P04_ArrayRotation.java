package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04_ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersArray = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int rotate = 1; rotate <= rotations; rotate++) {
            int firstNumber = numbersArray[0];
            for (int i = 0; i < numbersArray.length -1; i++) {
                numbersArray[i] = numbersArray[i+1];
            }
            numbersArray[numbersArray.length - 1] = firstNumber;
        }
        for (int elements : numbersArray)
        System.out.print(elements + " ");
    }
}
