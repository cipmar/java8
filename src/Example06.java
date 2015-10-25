import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<Person> persons = readPersons();

        // getting all persosns with age >= 25 and reducing to a comma separated string of names
        String red = persons.stream()
                .filter(p -> p.getAge() >= 25)
                .map(p -> p.getName())
                .collect(Collectors.joining(","));
        System.out.println(red);

        // now we want to reduce the list to a map where the key is the age and the value is the no of persons with that age
        Map<Integer, List<Person>> map = persons.stream()
                .filter(p -> p.getAge() >= 25)
                .collect(
                        Collectors.groupingBy(Person::getAge)
                );
        System.out.println(map);

        readPersons();
    }

    private static List<Person> readPersons() throws IOException {
        InputStreamReader isr = new InputStreamReader(Person.class.getResourceAsStream("persons.txt"));
        BufferedReader br = new BufferedReader(isr);
        List<Person> persons = new ArrayList<>();
        Stream<String> stream = br.lines();

        persons = stream.map(line -> {
            String[] tokens = line.split(" ");
            Person p = new Person(Integer.valueOf(tokens[1]), tokens[0]);
            return p;
        }).collect(Collectors.toList());

        return persons;
    }

    static class Person {
        private Integer age;
        private String name;

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
