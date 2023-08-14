package aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private String name;
    private int capacity;
    private int size;
    private List<Fish> fishInPool;

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add(Fish fish) {

        boolean isTheSameFish = false;

        for (Fish f : fishInPool) {
            if (f.getName().equals(fish.getName())) {
                isTheSameFish = true;
            }
        }
        if (!isTheSameFish && capacity > getFishInPool()) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        Fish removedFish = null;
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                removedFish = fish;
            }
            if (removedFish == null) {
                return false;
            }
        }
        fishInPool.remove(removedFish);
        return true;
    }

    public Fish findFish(String name) {
        return fishInPool.stream().filter(f -> f.getName().equals(name)).findAny().orElse(null);
    }

    public String report() {
        StringBuilder output = new StringBuilder();
        output.append(String.format("Aquarium: %s ^ Size: %d", getName(), getSize()));

        for (Fish fish : fishInPool) {
            output.append(System.lineSeparator())
                    .append(fish.toString());
        }
        return output.toString();
    }

}

