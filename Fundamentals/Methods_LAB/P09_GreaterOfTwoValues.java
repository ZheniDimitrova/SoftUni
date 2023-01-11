package fundamentalsSeptember2022_04Methods_LAB;

import java.util.Scanner;

public class P09_GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String type = scanner.nextLine();

        switch (type) {
            case "int":
                int num1 = Integer.parseInt(scanner.nextLine());
                int num2 = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(num1, num2));
                break;

            case "char":
                char symbol1 = scanner.nextLine().charAt(0);
                char symbol2 = scanner.nextLine().charAt(0);
                System.out.println(getMax(symbol1, symbol2));
                break;

            case "string":
                String input1 = scanner.nextLine();
                String input2 = scanner.nextLine();
                System.out.println(getMax(input1, input2));
                break;
        }
    }

    public static int getMax(int n1, int n2) {
        if (n1 > n2) {
            return n1;
        } else {
            return n2;
        }
    }

    public static char getMax(char firstSymbol, char secondSymbol) {
        if (firstSymbol > secondSymbol) {
            return firstSymbol;
        } else {
            return secondSymbol;
        }
    }

    public static String getMax(String firstInput, String secondInput) {
        if (firstInput.compareTo(secondInput) >= 0) {
            return firstInput;
        } else {
            return secondInput;
        }
    }
}
