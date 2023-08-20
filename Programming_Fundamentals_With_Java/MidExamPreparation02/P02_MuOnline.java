package fundamentalsSeptember2022_MidExam_Preparation;

import com.sun.source.tree.WhileLoopTree;

import java.util.Scanner;

public class P02_MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int health = 100;
        int bitcoins = 0;
        String[] dungeonRooms = scanner.nextLine().split("\\|");
        boolean isDead = false;

        for (int room = 0; room <= dungeonRooms.length - 1; room++) {

            String commandsInput = dungeonRooms[room];
            String[] command = commandsInput.split(" ");

            switch (command[0]) {

                case "potion":
                    int numCommand = Integer.parseInt(command[1]);
                    int difference = 100 - health;
                    health = health + numCommand;
                    if (health > 100) {
                        health = 100;
                        numCommand = difference;
                    }
                    System.out.printf("You healed for %d hp.%n", numCommand);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;

                case "chest":
                    int foundBitcoins = Integer.parseInt(command[1]);
                    bitcoins += foundBitcoins;
                    System.out.printf("You found %d bitcoins.%n", foundBitcoins);
                    break;

                default:
                    String monster = command[0];
                    int attackValue = Integer.parseInt(command[1]);
                    health -= attackValue;
                    if (health <= 0) {
                        System.out.printf("You died! Killed by %s.%n", monster);
                        System.out.printf("Best room: %d%n", room + 1);
                        isDead = true;
                        break;
                    } else {
                        System.out.printf("You slayed %s.%n", monster);
                    }
            }
            if (isDead) {
                break;

            }
        }
        if (!isDead) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d%n", health);
        }

    }

}

