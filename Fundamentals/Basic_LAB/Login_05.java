package fundamentalsSeptember2022_01Basic_Exercises;

import java.util.Scanner;

public class Login_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";
        int wrongPass = 0;

        for (int i = username.length() - 1; i >= 0; i--) {
            char letter = username.charAt(i);
            password += letter;

        }
        String enteredPass = scanner.nextLine();

        while (!enteredPass.equals(password)) {
            wrongPass++;
            if (wrongPass == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            enteredPass = scanner.nextLine();
        }
        if (enteredPass.equals(password)) {
            System.out.printf("User %s logged in.", username);

        }
    }
}

