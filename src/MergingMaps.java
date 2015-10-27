import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by mariusrop on 27.10.2015.
 */
public class MergingMaps {
    public static void main(String[] args) throws IOException {
        List<Person> allPersons = Person.readPersons();

        Map<Integer, List<Person>> map1 = allPersons.subList(0, 10).stream().collect(Collectors.groupingBy(Person::getAge));
        Map<Integer, List<Person>> map2 = allPersons.subList(10, allPersons.size()).stream().collect(Collectors.groupingBy(Person::getAge));

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
}
