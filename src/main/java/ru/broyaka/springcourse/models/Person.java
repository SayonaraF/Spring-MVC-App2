package ru.broyaka.springcourse.models;

import javax.validation.constraints.*;

public class Person {

    @NotEmpty(message = "Name is empty")
    @Size(min = 2, max = 30, message = "Name can be between 2 and 30 characters")
    private String name;
    @Min(value = 0, message = "Can't be negative")
    private int age;
    @NotEmpty(message = "Email is empty")
    @Email(message = "Incorrect email")
    private String email;
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your address should be in this format: Country, City, post index (6 digits)")
    private String address;
    private int id;
    public Person() {}

    public Person(int id, String name, int age, String email, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
