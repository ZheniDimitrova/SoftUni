package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Rabbit> data;

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

    public void add(Rabbit rabbit) {
        if (this.capacity > data.size()) {
            data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name) {
        Rabbit rabbit =  data.stream().filter(r -> r.getName().equals(name))
                .findFirst().orElse(null);

        return this.data.remove(rabbit);

        //return data.removeIf(r -> r.getName().equals(name));
    }

    public void removeSpecies(String species) {
        List<Rabbit> removed = data.stream().filter(rabbit -> rabbit.getSpecies().equals(species))
                .collect(Collectors.toList());

        removed.forEach(rabbit -> this.data.remove(rabbit));
        this.data.removeIf(rabbit -> rabbit.getSpecies().equals(species));
    }

    public Rabbit sellRabbit(String name) {
        Rabbit rabbit = data.stream().filter(rabbit1 -> rabbit1.getName().equals(name))
                .findFirst().orElseThrow();

        rabbit.setAvailable(false);
        return rabbit;
    }

    public List<Rabbit> sellRabbitBySpecies(String species) {
        List<Rabbit> rabbits = data.stream().filter(rabbit -> rabbit.getSpecies().equals(species))
                .collect(Collectors.toList());

        rabbits.forEach(rabbit -> rabbit.setAvailable(false));
        return rabbits;
    }

    public int count() {
        return data.size();

    }

    public String report() {

        List<Rabbit> rabbits = data.stream()
                .filter(Rabbit::isAvailable).collect(Collectors.toList());

        StringBuilder output = new StringBuilder();
        output.append(String.format("Rabbits available at %s:", getName()));

        rabbits.forEach(rabbit -> output.append(System.lineSeparator()).append(rabbit.toString()));


        return output.toString();

    }

}
