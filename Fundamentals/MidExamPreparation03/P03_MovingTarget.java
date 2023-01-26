package fundamentalsSeptember2022_MidExam_Preparation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> numbersList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        String commandInput = scanner.nextLine();

        while (!commandInput.equals("End")) {
            String[] command = commandInput.split(" ");

            switch (command[0]) {
                case "Shoot":
                    int shootIndex = Integer.parseInt(command[1]);
                    int power = Integer.parseInt(command[2]);
                    if (shootIndex < 0 || shootIndex > numbersList.size() - 1) {
                        break;
                    } else {
                        int shotNumber = numbersList.get(shootIndex);
                        shotNumber = shotNumber - power;
                        if (shotNumber <= 0) {
                            numbersList.remove(shootIndex);
                            break;
                        } else {
                            numbersList.set(shootIndex, shotNumber);
                        }
                    }
                    break;

                case "Add":
                    int addIndex = Integer.parseInt(command[1]);
                    int numberToAdd = Integer.parseInt(command[2]);

                    if (addIndex < 0 || addIndex > numbersList.size() - 1) {
                        System.out.println("Invalid placement!");
                        break;
                    } else {
                        numbersList.add(addIndex, numberToAdd);
                    }

                    break;

                case "Strike":

                    int strikeIndex = Integer.parseInt(command[1]);
                    int radius = Integer.parseInt(command[2]);
                    if (strikeIndex - radius < 0 || strikeIndex + radius > numbersList.size() - 1) {
                        System.out.println("Strike missed!");
                        break;
                    }

                    for(int i = strikeIndex+radius; i >= strikeIndex - radius; i--) {
                        numbersList.remove(i);
                    }

                    break;

            }

            commandInput = scanner.nextLine();

        }
        for (int i = 0; i < numbersList.size(); i++) {
            int currentNumber = numbersList.get(i);

            if (i != numbersList.size() - 1) {
                System.out.print(currentNumber + "|");
            } else {
                System.out.print(currentNumber);
            }

        }
    }
}
