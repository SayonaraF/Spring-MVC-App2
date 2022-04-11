package ru.broyaka.springcourse.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    @NotEmpty(message = "Name is empty")
    @Size(min = 2, max = 30, message = "Name can be between 2 and 30 characters")
    private String name;
    @Min(value = 0, message = "Can't be negative")
    private int age;
    @NotEmpty(message = "Email is empty")
    @Email(message = "Incorrect email")
    private String email;
    private int id;

    public Person() {}

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
