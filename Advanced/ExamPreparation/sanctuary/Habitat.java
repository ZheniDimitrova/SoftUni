package sanctuary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Habitat {

    private int capacity;
    private List<Elephant> data;

    public Habitat(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Elephant elephant) {
        if (this.capacity > data.size()) {
            data.add(elephant);
        }
    }

    public boolean remove(String name) {
        return data.removeIf(e -> e.getName().equals(name));

    }

    public Elephant getElephant(String retiredFrom) {
        return data.stream().filter(e-> e.getRetiredFrom().equals(retiredFrom)).findAny().orElse(null);
    }

    public Elephant getOldestElephant() {
        return Collections.max(data, Comparator.comparing(Elephant::getAge));
    }

    public int getAllElephants() {
        return  data.size();
    }

    public String getReport() {

        StringBuilder output = new StringBuilder();
        output.append(String.format("Saved elephants in the park:"));

        for (Elephant elephant : data){
            output.append(System.lineSeparator())
                    .append(String.format("%s came from: %s", elephant.getName(), elephant.getRetiredFrom()));
        }
         return output.toString();
    }

}
