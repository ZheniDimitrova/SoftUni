package fundamentalsSeptember2022_FinalExam_Dec04;

import java.util.Scanner;

public class P01_PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String userPassword = scanner.nextLine();
        StringBuilder password = new StringBuilder(userPassword);

        String input = scanner.nextLine();

        while (!input.equals("Complete")) {
            String[] commandsArr = input.split("\\s+");
            String command = commandsArr[0];

            switch (command) {
                case "Make":
                    String upperOrLower = commandsArr[1];
                    int index = Integer.parseInt(commandsArr[2]);

                    if (upperOrLower.equals("Upper")){
                        char upSymbol = Character.toUpperCase(password.charAt(index));
                       password.setCharAt(index, upSymbol);
                       System.out.println(password);

                    } else if(upperOrLower.equals("Lower")){
                         char lowSymbol = Character.toLowerCase(password.charAt(index));
                         password.setCharAt(index, lowSymbol);
                        System.out.println(password);

                    }
                    break;

                case "Insert":
                    int indexToInsert = Integer.parseInt(commandsArr[1]);
                    char symbol = commandsArr[2].charAt(0);
                    password.insert(indexToInsert, symbol);
                    System.out.println(password);
                    break;

                case "Replace":
                    char symbolToReplace = commandsArr[1].charAt(0);
                    int value = Integer.parseInt(commandsArr[2]);

                    if (password.toString().contains(symbolToReplace + "")){
                        char newChar = (char) (symbolToReplace + value);
                        String changedChar = password.toString().replace(symbolToReplace, newChar);
                        password = new StringBuilder(changedChar);
                        System.out.println(password);
                    }

                    break;

                case "Validation":


                    if (password.length() < 8){
                        System.out.println("Password must be at least 8 characters long!");
                    }
                    boolean isFoundUpper = false;
                    boolean isFoundLower = false;
                    boolean isDigit = false;
                    for (char validSymbol : password.toString().toCharArray()){
                        if (!Character.isDigit(validSymbol) && !Character.isLetter(validSymbol) && validSymbol != '_'){
                            System.out.println("Password must consist only of letters, digits and _!");
                        }
                        if (Character.isUpperCase(validSymbol)){
                            isFoundUpper = true;
                        } else if(Character.isLowerCase(validSymbol)){
                            isFoundLower = true;
                        } else if (Character.isDigit(validSymbol)){
                            isDigit = true;
                        }


                    }
                    if (!isFoundUpper){
                        System.out.println("Password must consist at least one uppercase letter!");
                    }
                    if (!isFoundLower){
                        System.out.println("Password must consist at least one lowercase letter!");
                    }
                    if (!isDigit){
                        System.out.println("Password must consist at least one digit!");
                    }

                    break;
            }


            input = scanner.nextLine();
        }


    }
}
