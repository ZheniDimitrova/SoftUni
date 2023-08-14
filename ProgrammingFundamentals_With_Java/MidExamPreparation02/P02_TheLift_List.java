package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_TheLift_List {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int people = Integer.parseInt(scanner.nextLine());
        List<Integer> liftList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int allSeatsInWagon = 4;
        boolean isFull = false;

        for (int wagon = 0; wagon < liftList.size(); wagon++) {
            int currentWagon = liftList.get(wagon);

            if (people <= 0){
                break;
            }

            if (currentWagon < allSeatsInWagon){
                int peopleInWagon = (allSeatsInWagon - currentWagon);
                if (people < peopleInWagon){
                    peopleInWagon = people;
                }
                people -=  peopleInWagon;
                liftList.set(wagon, currentWagon + peopleInWagon);
            }

        }
        if (liftList.get(liftList.size() - 1) == allSeatsInWagon){
            isFull = true;
        }


        if (!isFull) {
            System.out.println("The lift has empty spots!");
        } else if (people > 0) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people);
        }
        for (int wagon : liftList){
            System.out.print(wagon + " ");
        }


    }
}
