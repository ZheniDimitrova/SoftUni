package solid.products.food;

import solid.products.Product;

public abstract class Food implements Product {

    private double grams;
    private double caloriesPer100Grams;

    public Food(double grams, double caloriesPer100Grams) {
        this.grams = grams;
        this.caloriesPer100Grams = caloriesPer100Grams;
    }


    @Override
    public double getCalories() {
        return (caloriesPer100Grams / 100) * grams;
    }

    public double getCaloriesPer100Grams() {
        return caloriesPer100Grams;
    }

    public double getKilograms() {
        return grams / 1000;
    }
}
