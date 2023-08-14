package interfaceAndAbstarction_Exercise.birthdayCelebration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

//        List<Citizen> people = new ArrayList<>();
//        List<Pet> pets = new ArrayList<>();

        List<Birthable> birthdays = new ArrayList<>();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");

            String object = tokens[0];

            switch (object) {

                case "Citizen":
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDate = tokens[4];

                    Citizen citizen = new Citizen(name, age, id, birthDate);
                   // people.add(citizen);
                    birthdays.add(citizen);
                    break;

                case "Pet":
                    String petName = tokens[1];
                    String petBirthDate = tokens[2];

                    Pet pet = new Pet(petName, petBirthDate);
                   // pets.add(pet);
                    birthdays.add(pet);
                    break;

                case "Robot":
                    String model = tokens[1];
                    String robotId = tokens[2];

                    Robot robot = new Robot(model, robotId);
                    break;
            }


            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

//        for (Citizen citizen : people){
//            if (citizen.getBirthDate().endsWith(year)){
//                System.out.println(citizen.getBirthDate());
//            }
//        }
//
//        for (Pet pet : pets){
//            if (pet.getBirthDate().endsWith(year)) {
//                System.out.println(pet.getBirthDate());
//            }
//        }

            boolean isFound = false;
        for (Birthable birthable : birthdays){
            if (birthable.getBirthDate().endsWith(year)) {
                System.out.println(birthable.getBirthDate());
                isFound = true;
            }
        }

        if (!isFound){
            System.out.println("<no output>");
        }
    }
}
