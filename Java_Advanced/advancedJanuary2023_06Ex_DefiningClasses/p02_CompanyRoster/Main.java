package advancedJanuary2023_06Ex_DefiningClasses.p02_CompanyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Department> departmentsList = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            String[] info = scanner.nextLine().split("\\s+");
            String name = info[0];
            double salary = Double.parseDouble(info[1]);
            String position = info[2];
            String departmentName = info[3];
            Employee employee = null;
            Department department = null;

            boolean isFound = false;
            for(Department dep : departmentsList){
                if (dep.getName().equals(departmentName)){
                    isFound = true;
                    department = dep;

                }
            }
            if (!isFound){
                department = new Department(departmentName);
                departmentsList.add(department);
            }

            if (info.length == 6){
                String email = info[4];
                int age = Integer.parseInt(info[5]);
                employee = new Employee(name, salary, position, department, email, age);
            }
            else if (info.length == 5){
                String fourthElem = info[4];
                if (fourthElem.contains("@")){
                    String email = fourthElem;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(info[4]);
                    employee = new Employee(name, salary, position, department, age);

                }

            } else {
                employee = new Employee(name, salary, position, department);
            }


        }
        double maxSalary = departmentsList.stream().mapToDouble(d -> d.getAverageSalary()).max().getAsDouble();
        for (Department department : departmentsList){
            if (department.getAverageSalary() == maxSalary){
                System.out.println("Highest Average Salary: " + department.getName());
                department.getEmployeeList().stream().sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                        .forEach(employee -> System.out.println(employee.toString()));

            }
        }



    }
}
