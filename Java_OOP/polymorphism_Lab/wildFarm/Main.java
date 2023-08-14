package polymorphism_Lab.wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int lineCounter = 0;
        List<Animal> animalsList = new ArrayList<>();
        List<Food> foodsList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] info = input.split("\\s+");

            Animal animal = null;
            Food food = null;

            if (lineCounter % 2 == 0) {
                String animalType = info[0];
                String animalName = info[1];
                double animalWeight = Double.parseDouble(info[2]);
                String animalLivingRegion = info[3];
                String catBreed = "";
                if (animalType.equals("Cat")) {
                    catBreed = info[4];
                }

                switch (animalType) {

                    case "Cat":
                        animal = new Cat(animalName, animalType, animalWeight, animalLivingRegion, catBreed);
                        break;

                    case "Tiger":
                        animal = new Tiger(animalName, animalType, animalWeight, animalLivingRegion);
                        break;

                    case "Zebra":
                        animal = new Zebra(animalName, animalType, animalWeight, animalLivingRegion);
                        break;

                    case "Mouse":
                        animal = new Mouse(animalName, animalType, animalWeight, animalLivingRegion);
                        break;
                }
                animalsList.add(animal);


            } else {

                String foodType = info[0];
                int quantity = Integer.parseInt(info[1]);

                switch (foodType) {
                    case "Vegetable":
                        food = new Vegetable(quantity);
                        break;
                    case "Meat":
                        food = new Meat(quantity);
                        break;
                }
                animalsList.get(animalsList.size()-1).makeSound();
                animalsList.get(animalsList.size()-1).eat(food);
                foodsList.add(food);
            }

            lineCounter++;
            input = scanner.nextLine();
        }

            for (Animal animal : animalsList){
                System.out.println(animal.toString());
            }
    }

}
