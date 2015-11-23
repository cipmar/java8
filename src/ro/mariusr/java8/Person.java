package ro.mariusr.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by mariusrop on 27.10.2015.
 */
public class Person {
    private Integer index;
    private String firstName;
    private String lastName;
    private Integer age;

    public Integer getIndex() {
        return index;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Person(Integer index, String firstName, String lastName, Integer age) {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + age + ")";
    }

    public static List<Person> readPersons() throws IOException {
        InputStreamReader isr = new InputStreamReader(Person.class.getResourceAsStream("persons.txt"));
        List<Person> persons;

        try (BufferedReader br = new BufferedReader(isr)) {
            Stream<String> stream = br.lines();

            persons = stream.map(line -> {
                String[] tokens = line.split(" ");
                return new Person(Integer.valueOf(tokens[0]), tokens[1], tokens[2], Integer.valueOf(tokens[3]));
            }).collect(Collectors.toList());
        }

        return persons;
    }

    public static Person placeholder() {
        return new Person(Integer.MAX_VALUE, "<placeholder>", "", 0);
    }
}
