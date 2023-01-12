package fundamentalsSeptember2022_04Methods_Exercises;

import java.util.Scanner;

public class P04_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();

        if (!isValidLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        if (!isValidContent(password)) {
            System.out.println("Password must consist only of letters and digits");
        }
        if (!isContainAtLeast2Digits(password)) {
            System.out.println("Password must have at least 2 digits");
        }
        if (isValidLength(password) && isValidContent(password) && isContainAtLeast2Digits(password))
            System.out.println("Password is valid");
    }


    public static boolean isValidLength(String passInput) {
        return passInput.length() >= 6 && passInput.length() <= 10;
    }

    public static boolean isValidContent(String passInput) {
        for (char symbol : passInput.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isContainAtLeast2Digits(String passInput) {
        int digitsCount = 0;

        for (char symbol : passInput.toCharArray()) {
            if (Character.isDigit(symbol)) {
                digitsCount++;
            }
        }
        return digitsCount >= 2;
    }
}
