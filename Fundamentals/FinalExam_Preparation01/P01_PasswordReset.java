package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.Scanner;

public class P01_PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String pass = scanner.nextLine();
        StringBuilder passwordSb = new StringBuilder();

        String command = scanner.nextLine();

        while (!command.equals("Done")) {
            String[] commandsArr = command.split(" ");

            switch (commandsArr[0]) {
                case "TakeOdd":
                    for (int i = 0; i < pass.length(); i++) {
                        char symbol = pass.charAt(i);
                        if (i % 2 != 0) {
                            passwordSb.append(symbol);

                        }
                    }
                    pass = passwordSb.toString();
                    System.out.println(pass);
                    break;

                case "Cut":
                    int index = Integer.parseInt(commandsArr[1]);
                    int length = Integer.parseInt(commandsArr[2]);
                    String substringToRemove = pass.substring(index, index + length);
                    pass = pass.replaceFirst(substringToRemove, "");
                    System.out.println(pass);
                    break;

                case "Substitute":
                    String substring = commandsArr[1];
                    String substitute = commandsArr[2];
                    if (pass.contains(substring)) {
                        pass = pass.replaceAll(substring, substitute);
                        System.out.println(pass);

                    } else {
                        System.out.println("Nothing to replace!");
                    }

                    break;


            }
            command = scanner.nextLine();
        }
        System.out.println("Your password is: " + pass);

    }
}
