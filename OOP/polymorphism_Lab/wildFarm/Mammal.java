package polymorphism_Lab.wildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal{

    protected String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");

        return String.format("%s[%s, %s, %s, %d]", animalType, animalName, df.format(getAnimalWeight()), livingRegion, foodEaten);

    }


}
