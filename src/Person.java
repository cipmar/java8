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
    private String firstName;
    private String lastName;
    private Integer age;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public Person(String firstName, String lastName, Integer age) {
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
        List<Person> persons = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(isr)) {
            Stream<String> stream = br.lines();

            persons = stream.map(line -> {
                String[] tokens = line.split(" ");
                return new Person(tokens[0], tokens[1], Integer.valueOf(tokens[2]));
            }).collect(Collectors.toList());
        }

        return persons;
    }

    public static Person placeholder() {
        return new Person("<placeholder>", "", 0);
    }
}
