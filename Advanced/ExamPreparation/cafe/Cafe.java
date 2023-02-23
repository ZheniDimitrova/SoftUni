package cafe;

import java.util.*;

public class Cafe {

    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void  addEmployee(Employee employee) {

        if (this.capacity > employees.size()) {
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
                return employees.removeIf(e -> e.getName().equals(name));
    }

    public Employee getOldestEmployee() {
        return Collections.max(employees, Comparator.comparing(Employee::getAge));
    }

    public Employee getEmployee(String name) {

       return employees.stream().filter(e -> e.getName().equals(name)).findAny().orElse(null);
    }

    public int getCount() {
        return employees.size();
    }

    public String report() {

        StringBuilder output = new StringBuilder();

        output.append(String.format("Employees working at Cafe %s:", this.name));

        for (Employee employee : employees) {
            output.append(System.lineSeparator()).append(employee);
        }
        return output.toString();

    }


}
