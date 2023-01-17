package lab_P06_Students20;

public class Student20 {

    private String firstName;
    private String lastName;
    private int age;
    private String town;

    public Student20(String firstName, String lastName, int age, String town) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.town = town;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public String getTown() {
        return this.town;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
