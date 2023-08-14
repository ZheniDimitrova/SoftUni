package easterBasket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Basket {
    private String material;
    private int capacity;
    private List<Egg> data;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addEgg (Egg egg) {
        if (capacity > data.size()){
            data.add(egg);
        }
    }
    public boolean removeEgg (String color){

        return data.removeIf(egg -> egg.getColor().equals(color));
    }

    public Egg getStrongestEgg(){
       return Collections.max(data, Comparator.comparing(Egg::getStrength));
    }

    public Egg getEgg(String color) {
        return data.stream()
                .filter(egg -> egg.getColor().equals(color))
                .findFirst()
                .orElse(null);
    }
    public int getCount() {
        return data.size();
    }
    public String report() {
        StringBuilder sbOut = new StringBuilder();
        sbOut.append(String.format("%s basket contains:", this.material));
        for (Egg egg : data){
            sbOut.append(System.lineSeparator())
                    .append(egg);
        }
        return sbOut.toString();
    }
}
