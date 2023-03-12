package polymorphism_Lab.wildFarm;

public class Zebra extends Mammal{
    public Zebra(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");

    }

    @Override
    public void eat(Food food) {

            if (food instanceof Vegetable){
                this.foodEaten += food.getQuantity();
            } else {
                System.out.println("Zebras are not eating that type of food!");
            }

    }
}
