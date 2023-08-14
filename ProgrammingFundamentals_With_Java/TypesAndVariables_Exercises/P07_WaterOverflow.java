package fundamentalsSeptember2022_02DataTypesAndVariables_Exercises;

import java.util.Scanner;

public class P07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfLines = Integer.parseInt(scanner.nextLine());
        int capacity = 0;

        for (int i = 1; i <= numberOfLines ; i++) {
            int litersOfWater = Integer.parseInt(scanner.nextLine());
            capacity += litersOfWater;
            if (capacity > 255){
                System.out.println("Insufficient capacity!");
                capacity -= litersOfWater;
            }
            
        }
        System.out.println(capacity);
    }
}
