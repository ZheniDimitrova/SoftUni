package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.Scanner;

public class P01_TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        StringBuilder messageSb = new StringBuilder(encryptedMessage);

        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] instructions = input.split("\\|");

            switch (instructions[0]) {
                case "Move":
                    int numberOfLetters = Integer.parseInt(instructions[1]);
                    if (numberOfLetters > messageSb.toString().length()){
                        break;
                    }
                    StringBuilder firstLetters = new StringBuilder();

                    for (int i = 0; i < numberOfLetters; i++) {
                        char symbol = messageSb.charAt(i);
                        firstLetters.append(symbol);

                    }
                    messageSb.delete(0, numberOfLetters);
                    messageSb.append(firstLetters);

                    break;

                case "Insert":
                    int index = Integer.parseInt(instructions[1]);
                    if(index < 0 || index > messageSb.length()) break;
                    String value = instructions[2];
                    messageSb.insert(index, value);
                    break;

                case "ChangeAll":
                    String substring = instructions[1];
                    String replacement = instructions[2];

                    if (messageSb.toString().contains(substring)){
                       String newString =  messageSb.toString().replace(substring, replacement);
                       messageSb = new StringBuilder(newString);
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("The decrypted message is: " + messageSb);

    }
}
