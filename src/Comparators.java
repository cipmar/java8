import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mariusrop on 26.10.2015.
 */
public class Comparators {
    public static void main(String[] args) throws IOException {
        // new patterns to create comparators, using lambdas
        // chaining comparators
        Comparator<Person> compareLastNameAndFirstName = Comparator.comparing(Person::getLastName)
                .thenComparing(Person::getFirstName);

        List<Person> persons = Person.readPersons();

        persons.sort(compareLastNameAndFirstName);
        System.out.println(persons);

        // reversing the comparator
        persons.sort(compareLastNameAndFirstName.reversed());
        System.out.println(persons);
    }
}
