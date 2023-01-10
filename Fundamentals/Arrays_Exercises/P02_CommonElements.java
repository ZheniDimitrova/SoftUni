package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Scanner;

public class P02_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstInputArr = scanner.nextLine().split(" ");
        String[] secondInputArr = scanner.nextLine().split(" ");

        for (String elemSecondArr : secondInputArr) {
            for (String elemFirstArr : firstInputArr) {

                if (elemSecondArr.equals(elemFirstArr))
                    System.out.print(elemFirstArr + " ");

            }

        }
    }
}
