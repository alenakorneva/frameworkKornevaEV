package task3.service;

import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class User {

    private String firstName;
    private String lastName;
    private String email;
    private long age;
    private long salary;
    private String department;

    public User(String firstName, String lastName, String email, long age, long salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return age == user.age
                && salary == user.salary
                && Objects.equals(firstName, user.firstName)
                && Objects.equals(lastName, user.lastName)
                && Objects.equals(email, user.email)
                && Objects.equals(department, user.department);
    }
}
