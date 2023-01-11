package fundamentalsSeptember2022_04Methods_LAB;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08_MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        DecimalFormat result = new DecimalFormat("0.####");
        System.out.println(result.format(mathPower(number, power)));
    }

    public static Double mathPower(double num, int power) {
        double result = 1;
        for (int i = 1; i <=power ; i++) {
            result = result * num;
        }
        return result;
    }
}
