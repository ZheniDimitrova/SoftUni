package softUni;

import java.util.ArrayList;
import java.util.List;

public class SoftUni {

    private int capacity;
    private List<Student> data;

    public SoftUni(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCount() {
        return data.size();
    }

    public String insert(Student student) {

        if (getCapacity() == getCount()){
            return "The hall is full.";
        }

        for (Student studentInfo : data) {
            if (studentInfo.getFirstName().equals(student.getFirstName())
            && studentInfo.getLastName().equals(student.getLastName())) {

                return "Student is already in the hall.";
            }
        }
        data.add(student);
        return String.format("Added student %s %s.", student.getFirstName(), student.getLastName());

    }

    public  String remove(Student student) {
        if (data.removeIf(s -> s.getFirstName().equals(student.getFirstName()) && s.getLastName().equals(student.getLastName()))) {
            return String.format("Removed student %s %s.", student.getFirstName(), student.getLastName());
        }
        return "Student not found.";
    }

    public  Student getStudent(String firstName, String lastName) {
        return data
                .stream()
                .filter(s -> s.getFirstName().equals(firstName) && s.getLastName().equals(lastName))
                .findAny()
                .orElse(null);
    }

    public String getStatistics() {

        StringBuilder output = new StringBuilder();

        output.append(String.format("Hall size: %d", getCount()));

        for (Student student: data) {
            output.append(System.lineSeparator())
                    .append(student);
        }

        return output.toString();
    }
}
