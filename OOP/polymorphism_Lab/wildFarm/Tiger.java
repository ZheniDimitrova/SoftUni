package polymorphism_Lab.wildFarm;

public class Tiger extends Felime {

    public Tiger(String animalName, String animalType, Double animalWeight,  String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");

    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            foodEaten += food.getQuantity();
        } else {
            System.out.println("Tigers are not eating that type of food!");
        }

    }
}
