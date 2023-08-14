package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder activationKey = new StringBuilder(scanner.nextLine());

        String command = scanner.nextLine();

        while (!command.equals("Generate")) {
            String[] commandsArray = command.split(">>>");

            switch (commandsArray[0]) {
                case "Contains":
                    String substring = commandsArray[1];
                    if (activationKey.toString().contains(substring)) {
                        System.out.printf("%s contains %s%n", activationKey.toString(), substring);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;


                case "Flip":
                    String upperOrLower = commandsArray[1];
                    int startIndex = Integer.parseInt(commandsArray[2]);
                    int endIndex = Integer.parseInt(commandsArray[3]);

                    if (upperOrLower.equals("Upper")) {
                        String substringUp = activationKey.substring(startIndex, endIndex).toUpperCase();
                        activationKey.delete(startIndex, endIndex);
                        activationKey.insert(startIndex, substringUp);
                        System.out.println(activationKey);

                    } else if (upperOrLower.equals("Lower")) {
                        String substringToLow = activationKey.substring(startIndex, endIndex).toLowerCase();
                        activationKey.delete(startIndex, endIndex);
                        activationKey.insert(startIndex, substringToLow);
                        System.out.println(activationKey);
                    }
                    break;

                case "Slice":
                    int startI = Integer.parseInt(commandsArray[1]);
                    int endI = Integer.parseInt(commandsArray[2]);

                    activationKey.delete(startI, endI);
                    System.out.println(activationKey);

                    break;
            }
            command = scanner.nextLine();
        }
        System.out.println("Your activation key is: " + activationKey);
    }
}
