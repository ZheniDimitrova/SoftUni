package fundamentalsSeptember2022_FinalExam_Dec04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String regex = "!(?<command>[A-Z][a-z]{2,})!:(?<message>\\[[A-Za-z]{6,}\\])";
        Pattern pattern = Pattern.compile(regex);

        List<Integer> asciiMessage = new ArrayList<>();


        for (int i = 1; i <= n; i++) {
            String message = scanner.nextLine();

            Matcher matcher = pattern.matcher(message);


            if (matcher.find()) {
                String command = matcher.group("command");
                String validMessage = matcher.group("message");

                for (int j = 1; j <= validMessage.length() - 2; j++) {
                    char symbol = validMessage.charAt(j);
                    asciiMessage.add((int) symbol);
                }
                System.out.print(command + ": ");
                for (int ascii : asciiMessage) {
                    System.out.print(ascii + " ");
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }
        }

    }

}

