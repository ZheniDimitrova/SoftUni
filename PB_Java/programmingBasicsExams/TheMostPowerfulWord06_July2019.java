package programmingBasicsExams;

import java.util.Scanner;

public class TheMostPowerfulWord06_July2019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        int maxPower = Integer.MIN_VALUE;
        String maxWord = "";


        while (!word.equals("End of words")) {
            int power = 0;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                power += letter;
            }

            if (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u' || word.charAt(0) == 'y'
            || word.charAt(0) == 'A' || word.charAt(0) == 'E'|| word.charAt(0) == 'I' || word.charAt(0) == 'O' || word.charAt(0) == 'U' || word.charAt(0) == 'Y' ) {
                power *= word.length();
            } else {
                power = (int) Math.floor((double)power / (double)word.length());
            }
            if (power > maxPower) {
                maxPower = power;
                maxWord = word;
            }

            word = scanner.nextLine();
        }
        System.out.printf("The most powerful word is %s - %d", maxWord,maxPower );


    }
}

