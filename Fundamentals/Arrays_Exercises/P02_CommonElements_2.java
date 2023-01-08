package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Scanner;

public class P02_CommonElements_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstArr = scanner.nextLine().split(" ");
        String[] secondArr = scanner.nextLine().split(" ");

        for ( String secondElement:secondArr) {
            for (String firstElement :firstArr) {
                if (firstElement.equals(secondElement)){
                    System.out.print(firstElement + " ");
                }

            }

        }
    }
}
