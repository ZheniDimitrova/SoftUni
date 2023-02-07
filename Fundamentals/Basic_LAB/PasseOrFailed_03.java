package fundamentalsSeptember2022_01Basic_LAB;

import java.util.Scanner;

public class PasseOrFailed_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double grade = Double.parseDouble(scanner.nextLine());

        if(grade > 2.99){
            System.out.println("Passed!");
        } else {
            System.out.println("Failed!");
        }
    }
}
