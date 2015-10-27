import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by mariusrop on 24.10.2015.
 */
public class Example06 {
    public static void main(String[] args) throws IOException {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer sum = integers.stream().reduce(0, (int1, int2) -> int1 + int2);
        Optional<Integer> max = integers.stream().max(Comparator.<Integer>naturalOrder());
        System.out.println("sum: " + sum + "\nmax: " + max.orElse(0));

        // collectors are a special kind of reductions
        List<Person> persons = Person.readPersons();

        // getting all persons with age >= 25 and reducing to a comma separated string of names
        String red = persons.stream()
                .filter(p -> p.getAge() >= 25)
                .map(p -> p.getFirstName())
                .collect(Collectors.joining(","));
        System.out.println(red);

        // now we want to reduce the list to a map where the key is the age and the value is the no of persons with that age
        Map<Integer, List<Person>> map = persons.stream()
                .filter(p -> p.getAge() >= 25)
                .collect(
                        Collectors.groupingBy(Person::getAge)
                );
        System.out.println(map);
    }
}
