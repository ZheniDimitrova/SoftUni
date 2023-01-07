package fundamentalsSeptember2022_03Arrays_LAB;

import java.util.Scanner;

public class P01_DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] dayOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (n > 0 && n < 8){
            System.out.print(dayOfWeek[n-1]);
        } else{
            System.out.println("Invalid day!");
        }
    }
}
