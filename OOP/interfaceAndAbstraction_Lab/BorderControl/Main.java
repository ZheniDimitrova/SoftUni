package interfaceAndAbstraction_Lab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Identifiable> identifiables = new ArrayList<>();


        while(!input.equals("End") ) {
            String[] data = input.split("\\s+");

            Identifiable identifiable;

            if (data.length == 3){
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String id = data[2];

                identifiable = new Citizen(name, age, id);

            } else {
                String model = data[0];
                String idRobot = data[1];

                identifiable = new Robot(model, idRobot);
            }
            identifiables.add(identifiable);


            input = scanner.nextLine();
        }

        String fakeId = scanner.nextLine();

        identifiables.stream()
                 .filter(i -> i.getId().endsWith(fakeId))
                .map(Identifiable::getId)
                .forEach(System.out::println);

        }

    }



