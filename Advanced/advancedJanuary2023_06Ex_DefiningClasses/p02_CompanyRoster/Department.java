package advancedJanuary2023_06Ex_DefiningClasses.p02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Employee> employeeList;

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public String getName() {
        return name;
    }

    public Department(String name) {
        this.name = name;
        this.employeeList = new ArrayList<>();
    }

    public double getAverageSalary(){
        return employeeList.stream().mapToDouble(e -> e.getSalary()).average().orElse(0.0);
    }
}

