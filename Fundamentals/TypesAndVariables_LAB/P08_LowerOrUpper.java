package fundamentalsSeptember2022_02DataTypesAndVariables_LAB;

import java.util.Scanner;

public class P08_LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char character = scanner.nextLine().charAt(0);

        //     if (character >= 65 && character <= 90) {
        //       System.out.println("upper-case");
        // } else if (character >= 97 && character <= 122) {
        //   System.out.println("lower-case");
        //}

        if (Character.isUpperCase(character)) {
            System.out.println("upper-case");
        } else if (Character.isLowerCase(character)) {
            System.out.println("lower-case");
        }
    }
}
