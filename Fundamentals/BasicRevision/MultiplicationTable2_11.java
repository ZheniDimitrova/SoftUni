package fundamentalsSeptember2022_01Basic_LAB;

import java.util.Scanner;

public class MultiplicationTable2_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int multiplier =Integer.parseInt(scanner.nextLine());


        if (multiplier > 10){
            System.out.printf("%d X %d = %d", number, multiplier, number * multiplier);
        }
        for (int i = multiplier; i <= 10 ; i++) {
            System.out.printf("%d X %d = %d%n", number, i, number * i);
        }
    }
}
