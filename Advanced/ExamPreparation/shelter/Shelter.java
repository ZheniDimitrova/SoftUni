package shelter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Shelter {

    private int capacity;
    private List<Animal> data;

    public Shelter(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Animal animal) {
        if (capacity > data.size()) {
            data.add(animal);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(a -> a.getName().equals(name));
    }

    public Animal getAnimal(String name, String caretaker) {
        return data.stream()
                .filter(a -> a.getName().equals(name) && a.getCaretaker().equals(caretaker))
                .findAny()
                .orElse(null);
    }
    public Animal getOldestAnimal() {
        return Collections.max(data, Comparator.comparing(Animal::getAge));
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("The shelter has the following animals:"));

        for (Animal animal : data) {
            output.append(System.lineSeparator())
                    .append(animal.getName())
                    .append(" ")
                    .append(animal.getCaretaker());
        }
        return output.toString();
    }
}
