package fundamentalsSeptember2022_02DataTypesAndVariables_Exercises;

import java.util.Scanner;

public class P03_Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int capacityOfElevator = Integer.parseInt(scanner.nextLine());

       double courses = Math.ceil((double)numberOfPeople / capacityOfElevator);

       System.out.printf("%.0f", courses);
    }
}
