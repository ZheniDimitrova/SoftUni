package fundamentalsSeptember2022_02DataTypesAndVariables_LAB;

import java.util.Scanner;

public class P05_ConcatNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String delimiter = scanner.nextLine();

        System.out.print(firstName + delimiter + lastName);
    }
}
