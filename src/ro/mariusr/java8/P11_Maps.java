package ro.mariusr.java8;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by mariusrop on 26.10.2015.
 * <p>
 * new methods in Map interface!
 */
public class P11_Maps {

    /**
     * miscellaneous maps improvements
     */
    private static void miscellaneousImprovements() throws IOException {
        Map<Integer, Person> map = readPersons();
        map.put(null, new Person(100, "Tom", "George", 34));

        // forEach, a default method in Map interface!
        map.forEach((key, person) -> System.out.println(key + "->" + person));

        // getOrDefault
        Person p = map.getOrDefault(35, Person.placeholder());
        System.out.println(p);

        // replace
        map.replace(1, new Person(101, "new", "person", 33));
        System.out.println(map);

        // putIfAbsent
        map.putIfAbsent(2, Person.placeholder());
        map.putIfAbsent(102, new Person(102, "another new", "person", 34));
        System.out.println(map);

    }

    /**
     *
     */
    private static void mergingMaps() throws IOException {
        List<Person> allPersons = Person.readPersons();

        Map<Integer, List<Person>> map1 = allPersons.subList(0, 15).stream().collect(Collectors.groupingBy(Person::getAge));
        Map<Integer, List<Person>> map2 = allPersons.subList(15, allPersons.size()).stream().collect(Collectors.groupingBy(Person::getAge));

        // merging two maps
        map2.entrySet().stream()
                .forEach(entry ->
                        map1.merge(entry.getKey(),
                                entry.getValue(),
                                (l1, l2) -> {
                                    l1.addAll(l2);
                                    return l1;
                                }));

        map1.entrySet().forEach(System.out::println);
    }

    private static Map<Integer, Person> readPersons() throws IOException {
        List<Person> person = Person.readPersons();

        return person
                .stream()
                .collect(Collectors.toMap(
                        p -> p.getIndex(),
                        Function.identity()
                ));
    }

    public static void main(String[] args) throws IOException {
        miscellaneousImprovements();
        mergingMaps();
    }
}
