package fundamentalsSeptember2022_08TextProcessing_Exercises;

import java.util.Scanner;

public class P01_ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         String[] namesArr = scanner.nextLine().split(", ");

        for (int i = 0; i < namesArr.length; i++) {
            String currentUsername = namesArr[i];
            if (isValidUsername(currentUsername)){
                System.out.println(currentUsername);
            }
        }

    }
    public static boolean isValidUsername(String username){

        if(username.length() < 3 || username.length() > 16){
            return false;
        }
        for (char symbol : username.toCharArray()){
            if (!Character.isLetterOrDigit(symbol) && symbol!='-' && symbol != '_'){
                return false;
            }
        }
        return true;
    }
}
