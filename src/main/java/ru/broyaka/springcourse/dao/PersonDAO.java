package ru.broyaka.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.broyaka.springcourse.config.ConstDB;
import ru.broyaka.springcourse.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(ConstDB.URL, ConstDB.USER, ConstDB.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> index() {
        List<Person> people = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM person";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));

                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    public Person show(int id) {
        Person person = null;

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Person WHERE id=?");
            statement.setInt(1, id);

            ResultSet set = statement.executeQuery();

            set.next();

            person = new Person();

            person.setId(set.getInt("id"));
            person.setName(set.getString("name"));
            person.setAge(set.getInt("age"));
            person.setEmail(set.getString("email"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    public void save(Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO person(name, age, email) VALUES(?,?,?)");

            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setString(3, person.getEmail());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person person) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE Person SET name=?, age=?, email=? WHERE id=?");

            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.setString(3, person.getEmail());
            statement.setInt(4, person.getId());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM Person WHERE id=?");

            statement.setInt(1, id);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
