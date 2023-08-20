package fundamentalsSeptember2022_04Methods_LAB;

import java.util.Scanner;

public class P07_RepeatingString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        int times = Integer.parseInt(scanner.nextLine());

        System.out.println(repeatString(text, times));

    }
    public static String repeatString (String input, int counts){
        String newInput = "";
        for (int i = 1; i <=counts ; i++) {
            newInput += input;
        }
        return  newInput;
    }
}
