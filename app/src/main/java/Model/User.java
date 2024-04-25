package Model;

public class User {
    private String name;
    private String lastName;
    private int age;
    private String email;

    public User(String name, String lastName, int age, String email) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}
