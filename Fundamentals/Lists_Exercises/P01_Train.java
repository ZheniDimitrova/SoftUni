package fundamentalsSeptember2022_05Lists_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> wagonsList = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxCapacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            String[] input = command.split(" ");
            if (input[0].equals("Add")) {
                int peopleToAdd = Integer.parseInt(input[1]);
                wagonsList.add(peopleToAdd);

            } else {
                int addPeople = Integer.parseInt(input[0]);

                for (int i = 0; i < wagonsList.size(); i++) {
                    int sumPeople = 0;
                    int currentPeople = wagonsList.get(i);
                    sumPeople = currentPeople + addPeople;

                    if (maxCapacity >= sumPeople) {
                        wagonsList.set(i, sumPeople);
                        break;
                    }
                }
            }
            command = scanner.nextLine();
        }

        for (int peopleInWagon : wagonsList) {
            System.out.print(peopleInWagon + " ");
        }

    }
}
