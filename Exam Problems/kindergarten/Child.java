package kindergarten;

public class Child {
    private String firstName;
    private String lastName;
    private int age;
    private String parentName;
    private String contactNumber;

    public Child(String firstName, String lastName, int age, String parentName, String contactNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.parentName = parentName;
        this.contactNumber = contactNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return this.age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getParentName() {
        return parentName;
    }

    @Override
    public String toString() {
        return String.format("Child: %s %s, Age: %d, Contact info: %s - %s", getFirstName(), getLastName(), getAge(), getParentName(), getContactNumber());
    }
}
