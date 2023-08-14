package dealership;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Dealership {

    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void add(Car car) {
        if (capacity > data.size()) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        return data.removeIf(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model));
    }
    public Car getLatestCar() {
        return Collections.max(data, Comparator.comparing(Car::getYear));
    }
    public Car getCar(String manufacturer, String model) {
        return data.stream()
                .filter(c -> c.getManufacturer().equals(manufacturer) && c.getModel().equals(model))
                .findAny()
                .orElse(null);
    }
    public int getCount() {
        return data.size();
    }
    public String getStatistics() {
        StringBuilder output = new StringBuilder();
        output.append(String.format(" The cars are in a car dealership %s:", this.name));

        for (Car car : data) {
            output.append(System.lineSeparator())
                    .append(car);
        }
        return output.toString();

    }
}
