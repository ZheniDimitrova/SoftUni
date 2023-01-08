package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Scanner;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagonsCount = Integer.parseInt(scanner.nextLine());

        int[] wagonArr = new int[wagonsCount];
        int sum = 0;

        for (int i = 0; i < wagonsCount; i++) {
            int people = Integer.parseInt(scanner.nextLine());
            wagonArr[i] += people;
            sum += people;
        }
        for (int elements : wagonArr){
            System.out.print(elements + " ");
        }
        System.out.println();
        System.out.println(sum);

    }
}
