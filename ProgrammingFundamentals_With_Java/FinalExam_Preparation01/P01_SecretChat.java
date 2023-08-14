package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.Scanner;

public class P01_SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();
        StringBuilder messageSb = new StringBuilder(message);

        String input = scanner.nextLine();

        while (!input.equals("Reveal")) {
            String[] instruction = input.split(":\\|:");
            switch (instruction[0]) {

                case "InsertSpace":

                    int indexToInsert = Integer.parseInt(instruction[1]);
                    messageSb.insert(indexToInsert, " ");
                    System.out.println(messageSb);
                    break;

                case "Reverse":
                    String substring = instruction[1];

                    if (messageSb.toString().contains(substring)) {
                        StringBuilder newSubstring = new StringBuilder(substring);
                        messageSb.delete(messageSb.indexOf(substring), messageSb.indexOf(substring)+substring.length());
                        newSubstring.reverse();
                        messageSb.append(newSubstring.toString());
                        System.out.println(messageSb);
                    } else {
                        System.out.println("error");
                    }
                    break;

                case "ChangeAll":
                    String substringToChange = instruction[1];
                    String replacement = instruction[2];

                    if (messageSb.toString().contains(substringToChange)){
                      String newMessage =  message.replaceAll(substringToChange, replacement);
                      messageSb = new StringBuilder(newMessage);
                    }
                    System.out.println(messageSb);
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.println("You have a new text message: " + messageSb);
    }
}
