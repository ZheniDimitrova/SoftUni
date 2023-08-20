package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.Scanner;

public class P01_CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int battlesCount = 0;
        boolean noMoreEnergy = false;

        while (!input.equals("End of battle")) {
            int distance = Integer.parseInt(input);

            if (energy >= distance) {
                energy -= distance;
                battlesCount++;
            } else{
                noMoreEnergy = true;
                break;
            }

            if (battlesCount % 3 == 0) {
                energy += battlesCount;
            }

            input = scanner.nextLine();
        }
        if (noMoreEnergy) {
            System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", battlesCount, energy);
        } else {
            System.out.printf("Won battles: %d. Energy left: %d", battlesCount, energy);
        }

    }
}
