import java.util.HashMap;
import java.util.Map;

/**
 * Created by mariusrop on 26.10.2015.
 */
public class Maps {
    public static void main(String[] args) {
        Map<Integer, Person> map = new HashMap<>();

        map.put(1, new Person("John", "Doe", 22));
        map.put(2, new Person("Mike", "Alloy", 43));
        map.put(3, new Person("Marry", "Pop", 21));
        map.put(null, new Person("Tom", "George", 34));

        // forEach!!!
        map.forEach((key, person) -> System.out.println(key + "->" + person));

        // getOrDefault
        Person p = map.getOrDefault(35, Person.placeholder());
        System.out.println(p);

        // replace and putIfAbsent
        map.replace(1, new Person("new", "person", 33));
        System.out.println(map);

        map.putIfAbsent(2, Person.placeholder());
        map.putIfAbsent(6, new Person("another new", "person", 34));
        System.out.println(map);
    }
}
