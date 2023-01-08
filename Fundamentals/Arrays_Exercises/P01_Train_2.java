package fundamentalsSeptember2022_03Arrays_Exercises;

import java.util.Scanner;

public class P01_Train_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());

        int[] train = new int[wagons];

        int sumPeople = 0;

        for (int wagon = 1; wagon <= wagons; wagon++) {
            int people = Integer.parseInt(scanner.nextLine());
            train[wagon - 1] += people;
            sumPeople += people;
        }

        for(int people : train){
            System.out.print(people + " ");
        }
        System.out.println();
        System.out.println(sumPeople);
    }
}
