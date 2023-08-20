package fundamentalsSeptember2022_04Methods_Exercises;

import java.util.Scanner;

public class P03_CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstSymbol = scanner.nextLine().charAt(0);
        char secondSymbol = scanner.nextLine().charAt(0);

        printCharactersInRange(firstSymbol, secondSymbol);
    }

    public static void printCharactersInRange(char symbol1, char symbol2) {

        if (symbol1 < symbol2) {
            for (char symbol = (char) (symbol1 + 1); symbol < symbol2 ; symbol++) {
             System.out.print(symbol + " ");
            }
        } else {
            for (char symbol = (char)(symbol2 + 1); symbol < symbol1; symbol++){
                System.out.print(symbol + " ");
            }
        }
    }

}
