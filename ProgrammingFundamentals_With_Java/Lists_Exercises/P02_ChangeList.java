package fundamentalsSeptember2022_05Lists_Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();

        while(!command.equals("end")){
            String[] inputCommand = command.split("\\s+");

            switch (inputCommand[0]){
                case "Delete":
                    int numberToDelete = Integer.parseInt(inputCommand[1]);
                    numbersList.removeAll(Arrays.asList(numberToDelete));
                    break;

                case "Insert":
                    int numberToInsert = Integer.parseInt(inputCommand[1]);
                    int indexToInsert = Integer.parseInt(inputCommand[2]);
                    numbersList.add(indexToInsert, numberToInsert);
                    break;
            }
            command = scanner.nextLine();
        }

        System.out.print(numbersList.toString().replaceAll("[\\[\\],]", ""));
    }
}
