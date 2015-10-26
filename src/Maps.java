import java.util.HashMap;
import java.util.Map;

/**
 * Created by mariusrop on 26.10.2015.
 */
public class Maps {
    public static void main(String[] args) {
        Map<Integer, Person> map = new HashMap<>();

        map.put(1, new Person("John", "Doe"));
        map.put(2, new Person("Mike", "Alloy"));
        map.put(3, new Person("Marry", "Pop"));
        map.put(null, new Person("Tom", "George"));

        // forEach!!!
        map.forEach((key, person) -> System.out.println(key + "->" + person));

        // getOrDefault
        Person p = map.getOrDefault(35, Person.placeholder());
        System.out.println(p);

        // replace and putIfAbsent
        map.replace(1, new Person("new", "person"));
        System.out.println(map);

        map.putIfAbsent(2, Person.placeholder());
        map.putIfAbsent(6, new Person("another new", "person"));
        System.out.println(map);
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

        public static Person placeholder() {
            return new Person("<placeholder>", "");
        }

        @Override
        public String toString() {
            return String.join(" ", firstName, lastName);
        }
    }
}
