package fundamentalsSeptember2022_03Arrays_LAB;

import java.util.Scanner;

public class P04_ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputArr = scanner.nextLine().split(" ");

        for (int i = 0; i < inputArr.length / 2; i++) {
            String firstElem = inputArr[i];
            inputArr[i] = inputArr[inputArr.length -1 -i];
            inputArr[inputArr.length - 1 - i] = firstElem;

        }
        System.out.println(String.join(" ", inputArr));
    }
}
