package fundamentalsSeptember2022_08TextProcessing_Exercises;

import java.util.Scanner;

public class P05_MultiplyBigNumber_2_String {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());
        int remainder = 0;

        StringBuilder finalResult = new StringBuilder();

        for (int i = number.length() -1; i >= 0 ; i--) {
            int digit = Integer.parseInt(String.valueOf(number.charAt(i)));
            int product = digit * multiplier + remainder;
            if (i == 0){
                finalResult.insert(0, product);
            } else {
                int digitToAdd = product % 10;
                remainder = product / 10;
                finalResult.insert(0, digitToAdd);
            }
        }
        while(finalResult.charAt(0) == '0' && finalResult.length() > 1){
            finalResult.deleteCharAt(0);
        }
        System.out.println(finalResult);
    }
}
