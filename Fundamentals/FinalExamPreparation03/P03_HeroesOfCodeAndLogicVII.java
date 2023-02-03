package fundamentalsSeptember2022_FinalExam_Preparation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P03_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfHeroes = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> mapHP = new LinkedHashMap<>();
        Map<String, Integer> mapMP = new LinkedHashMap<>();

        for (int hero = 1; hero <= numberOfHeroes ; hero++) {
            String[] heroesInfo = scanner.nextLine().split("\\s+");
            String heroName = heroesInfo[0];
            int hp = Integer.parseInt(heroesInfo[1]);
            int mp = Integer.parseInt(heroesInfo[2]);

            if (hp <= 100){
                mapHP.put(heroName, hp);
            }
            if (mp <= 200){
                mapMP.put(heroName, mp);
            }
        }

        String command = scanner.nextLine();

        while(!command.equals("End")){

            if (command.contains("CastSpell")){
                String name = command.split("\\s+-\\s+")[1];
                int mpNeeded = Integer.parseInt(command.split("\\s+-\\s+")[2]);
                String spellName = command.split("\\s+-\\s+")[3];

                if (mapMP.get(name) >= mpNeeded){
                    int currentMP = mapMP.get(name) - mpNeeded;
                    System.out.printf("%s has successfully cast %s and now has %d MP!%n", name, spellName, currentMP);
                    mapMP.put(name, currentMP);
                } else {
                    System.out.printf("%s does not have enough MP to cast %s!%n", name, spellName);
                }


            } else if (command.contains("TakeDamage")){
                String name = command.split("\\s+-\\s+")[1];
                int damage = Integer.parseInt(command.split("\\s+-\\s+")[2]);
                String attacker = command.split("\\s+-\\s+")[3];

                int currentHP = mapHP.get(name) - damage;
                if (currentHP > 0){
                    System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n",name, damage, attacker, currentHP);
                    mapHP.put(name, currentHP);
                } else{
                    System.out.printf("%s has been killed by %s!%n", name, attacker);
                    mapHP.remove(name);
                    mapMP.remove(name);
                }

            } else if (command.contains("Recharge")){
                String name = command.split("\\s+-\\s+")[1];
                int amount = Integer.parseInt(command.split("\\s+-\\s+")[2]);

                int currentMP = mapMP.get(name) + amount;

                if (currentMP > 200){
                    currentMP = 200;
                }
                System.out.printf("%s recharged for %d MP!%n", name, currentMP - mapMP.get(name));
                mapMP.put(name, currentMP);

            } else if (command.contains("Heal")){
                String name = command.split("\\s+-\\s+")[1];
                int amount = Integer.parseInt(command.split("\\s+-\\s+")[2]);

                int currentHP = mapHP.get(name) + amount;

                if (currentHP > 100){
                    currentHP = 100;
                }
                System.out.printf("%s healed for %d HP!%n", name, currentHP - mapHP.get(name));
                mapHP.put(name, currentHP);
            }

            command = scanner.nextLine();
        }

        mapHP.entrySet().forEach(entry -> {
           String heroName = entry.getKey();
            System.out.println(heroName);
           System.out.printf("HP: %d%n", entry.getValue());
           System.out.printf("MP: %d%n", mapMP.get(heroName));
        });

    }
}
