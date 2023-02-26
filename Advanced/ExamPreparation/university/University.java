package university;

import java.util.ArrayList;
import java.util.List;

public class University {

    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {

        return students;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        String result = "";
        boolean isEquals = false;

        for (Student s : students) {
            if (s.getFirstName().equals(student.getFirstName()) && s.getLastName().equals(student.getLastName())){
                isEquals = true;
                break;
            }

        }
        if (!isEquals && this.students.size() < this.capacity) {
            this.students.add(student);
            result = String.format("Added student %s %s", student.getFirstName(), student.getLastName());

        } else if (isEquals) {
            result = "Student is already in the university";
        } else {
            result = "No seats in the university";
        }
        return result;
    }


    public String dismissStudent(Student student) {
          boolean isFound = false;
        for (Student s : students){
            if (s.getFirstName().equals(student.getFirstName()) && s.getLastName().equals(student.getLastName())) {
                students.remove(s);
                isFound = true;
                break;
            }
        }
       // boolean isFound = students.removeIf(s -> s.getFirstName().equals(student.getFirstName()) && s.getLastName().equals(student.getLastName()));
        if (!isFound) {
            return "Student not found";
        } else {
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        }

    }
    public Student getStudent(String firstName, String lastName) {
         Student student = null;
         for (Student s : students) {
             if(s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)){
                 student = s;
                 break;
             }
         }
        return student;
    }

    public String getStatistics() {
        StringBuilder sbOut = new StringBuilder();

        for (Student s : students) {
            sbOut.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                     s.getFirstName(), s.getLastName(), s.getBestSubject()));
                    sbOut.append(System.lineSeparator());
        }
        return sbOut.toString().trim();
    }

}
