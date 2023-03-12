package polymorphism_Lab.wildFarm;

public abstract class Animal {

    protected String animalName;
    protected String animalType;
    protected Double animalWeight;
    protected Integer foodEaten;

    public Animal(String animalName, String animalType, Double animalWeight) {
        this.animalName = animalName;
        this.animalType = animalType;
        this.animalWeight = animalWeight;
        this.foodEaten = 0;
    }

    protected String getAnimalName() {
        return animalName;
    }

   protected String getAnimalType() {
        return animalType;
    }

    protected Double getAnimalWeight() {
        return animalWeight;
    }

    protected Integer getFoodEaten() {
        return foodEaten;
    }

    public abstract void makeSound();
    public abstract void eat(Food food);


}
