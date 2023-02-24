package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (capacity > data.size()) {
            data.add(parrot);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(p -> p.getName().equals(name));
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = data.stream().filter(p -> p.getName().equals(name)).findFirst().orElseThrow();

        parrot.setAvailable(false);
        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrots = data.stream().filter(p -> p.getSpecies().equals(species)).collect(Collectors.toList());

        for (Parrot parrot : parrots) {
            parrot.setAvailable(false);
        }
        return parrots;
    }

    public int count() {
        return data.size();
    }

    public String report() {

        List<Parrot> parrots = data.stream().filter(Parrot::isAvailable).collect(Collectors.toList());

        StringBuilder output = new StringBuilder();
        output.append(String.format("Parrots available at %s:", this.name));

        for (Parrot parrot : parrots) {
            output.append(System.lineSeparator()).append(parrot);
        }
        return output.toString();
    }
}
