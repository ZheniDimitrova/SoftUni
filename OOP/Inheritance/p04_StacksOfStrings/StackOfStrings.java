package Inheritance.p04_StacksOfStrings;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {

    private List<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push (String element) {
        this.data.add(element);
    }

    public  String pop() {
        String poopedElement = data.get(data.size() - 1);
        data.remove(data.size() - 1);

        return poopedElement;
    }

    public String peek() {
        return this.data.get(data.size() - 1);

    }

    public boolean isEmpty() {
        return this.data.isEmpty();

    }
}
