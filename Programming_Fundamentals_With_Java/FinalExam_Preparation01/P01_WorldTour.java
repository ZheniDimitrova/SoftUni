package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.Scanner;

public class P01_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder destinationsSb = new StringBuilder(scanner.nextLine());

        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            String[] command = input.split(":");

            switch (command[0]) {

                case "Add Stop":
                    int index = Integer.parseInt(command[1]);
                    String stringToInsert = command[2];

                    if (index >= 0 && index <= destinationsSb.length() - 1){
                        destinationsSb.insert(index, stringToInsert);

                    }
                    System.out.println(destinationsSb);
                    break;

                case "Remove Stop":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);

                    if (startIndex >= 0 && startIndex <= destinationsSb.length()-1 && endIndex >= 0 && endIndex <= destinationsSb.length() -1 ){
                        destinationsSb.delete(startIndex, endIndex + 1);

                    }
                    System.out.println(destinationsSb);
                    break;

                case "Switch":
                    String oldString = command[1];
                    String newString = command[2];

                    if (destinationsSb.toString().contains(oldString)){
                        String newText =  destinationsSb.toString(). replaceAll(oldString, newString);
                        destinationsSb = new StringBuilder(newText);

                    }
                    System.out.println(destinationsSb);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + destinationsSb);

    }
}
