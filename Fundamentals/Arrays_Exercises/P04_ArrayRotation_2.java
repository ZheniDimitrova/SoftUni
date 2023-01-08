package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Scanner;

public class P04_ArrayRotation_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbersArr = scanner.nextLine().split(" ");
        int rotations = Integer.parseInt(scanner.nextLine());

        for (int rotate = 1; rotate <= rotations; rotate++) {
            String firstElement = numbersArr[0];
            for (int i = 0; i < numbersArr.length -1 ; i++) {
                numbersArr[i] = numbersArr[i + 1];
            }
            numbersArr[numbersArr.length - 1] = firstElement;

        }
        for(String elements:numbersArr){
            System.out.print(elements + " ");
        }
    }
}
