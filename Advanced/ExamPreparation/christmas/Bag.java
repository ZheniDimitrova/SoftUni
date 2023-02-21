package christmas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Bag {

    private String color;
    private int capacity;
    private List<Present> data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }

    public int count() {
        return data.size();
    }

    public void add(Present present) {
        if (getCapacity() > count()) {
            data.add(present);
        }
    }

    public boolean remove (String name) {
       return this.data.removeIf(p -> p.getName().equals(name));
    }
    public Present heaviestPresent() {
        return Collections.max(data, Comparator.comparing(Present::getWeight));
    }

    public Present getPresent(String name) {
        return data.stream()
                .filter(present -> present.getName().equals(name))
                .findAny()
                .orElse(null);
    }

    public String report() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("%s bag contains:", getColor()));

        for (Present present : data){
            out.append(System.lineSeparator())
                    .append(present);
        }
        return out.toString();
    }
}
