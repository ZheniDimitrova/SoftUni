package fundamentalsSeptember2022_01Basic_LAB;

import java.util.Scanner;

public class BackIn30Minutes_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstHour =Integer.parseInt(scanner.nextLine());
        int firstMinutes = Integer.parseInt(scanner.nextLine());

        int allMinutes = firstHour * 60 + firstMinutes +30;

        int hour = allMinutes / 60;
        int minutes = allMinutes % 60;
        if (hour > 23){
            hour = 0;
        }
        System.out.printf("%d:%02d", hour, minutes);
    }
}
