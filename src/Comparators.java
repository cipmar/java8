import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mariusrop on 26.10.2015.
 */
public class Comparators {
    public static void main(String[] args) {
        // new patterns to create comparators, using lambdas
        // chaining comparators
        Comparator<Person> compareLastNameAndFirstName = Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName);

        List<Person> persons = Arrays.asList(
                new Person("John", "Doe"),
                new Person("Mike", "Allow"),
                new Person("Dave", "Molly"),
                new Person("Marry", "Pop"),
                new Person("Silvia", "Kane"),
                new Person("Kate", "Moore")
        );

        persons.sort(compareLastNameAndFirstName);
        System.out.println(persons);

        // reversing the comparator
        persons.sort(compareLastNameAndFirstName.reversed());
        System.out.println(persons);
    }

    private static class Person {
        private String firstName;
        private String lastName;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        @Override
        public String toString() {
            return String.join(" ", firstName, lastName);
        }
    }
}
