package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.Arrays;
import java.util.Scanner;

public class P02_TheLift_Arrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int peopleInQueue = Integer.parseInt(scanner.nextLine());
        int[] liftCabin = Arrays.stream(scanner.nextLine()
                        .split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        for (int i = 0; i < liftCabin.length; i++) {
            int peopleInCabin = liftCabin[i];
            int freeSeats = 4 - peopleInCabin;

            if (peopleInCabin == 4){
                continue;
            }
            if(freeSeats >= peopleInQueue){
                liftCabin[i] += peopleInQueue;
                peopleInQueue = 0;
                break;
            }
            liftCabin[i] = 4;
            peopleInQueue -= freeSeats;

        }
        boolean emptySeats = false;
        for (int peopleInCabin : liftCabin){
            if (peopleInCabin < 4){
                emptySeats = true;
                break;
            }
        }

        if (emptySeats){
            System.out.println("The lift has empty spots!");
        }
        else if (peopleInQueue != 0 && !emptySeats){
            System.out.printf("There isn't enough space! %d people in a queue!%n", peopleInQueue);
        }

        for (int cabin : liftCabin){
            System.out.print(cabin + " ");
        }

    }
}
