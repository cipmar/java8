package ro.mariusr.java8;

import java.io.IOException;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static ro.mariusr.java8.Person.readPersons;

/**
 * Created by mariusrop on 12.11.2015.
 */
public class P10_Collectors {
    /**
     * Collectors.toList() example
     */
    private static void collectingIntoAList() throws IOException {
        List<Person> persons = readPersons();

        List<String> lastNames = persons
                .stream()
                .filter(p -> p.getAge() > 25)
                .map(Person::getLastName)
                .sorted()
                .collect(Collectors.toList()); // toSet()

        System.out.println(lastNames);
    }

    /**
     * Collectors.groupingBy() example
     */
    private static void groupingByAge() throws IOException {
        List<Person> persons = readPersons();

        Map<Integer, List<Person>> map = persons
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));
        System.out.println(map);
    }

    /**
     * Collectors.toMap() example
     */
    private static void toMapExample() throws IOException {
        List<Person> persons = readPersons();

        Map<Integer, String> map = persons
                .stream()
                .collect(Collectors.toMap(
                        p -> p.getAge(),
                        p -> p.getLastName(),
                        (p1, p2) -> p1 + ";" + p2
                ));

        System.out.println(map);
    }

    /**
     * Collectors.joining() example
     */
    private static void joiningPersonsByLastName() throws IOException {
        List<Person> persons = readPersons();

        String s = persons.stream()
                .filter(p -> p.getAge() > 25)
                .map(Person::getLastName)
                .sorted()
                .collect(Collectors.joining(",", "|", "|"));

        System.out.println(s);
    }

    /**
     * Collectors.averagingInt() example
     */
    private static void aggregatingTheElements() throws IOException {
        List<Person> persons = readPersons();

        Double averageAge = persons
                .stream()
                .collect(Collectors.averagingInt(Person::getAge));

        System.out.println(averageAge);
    }

    /**
     * Collectors.summarizingInt() example
     */
    private static void summarizingByAge() throws IOException {
        List<Person> persons = readPersons();

        IntSummaryStatistics statistics = persons
                .stream()
                .collect(Collectors.summarizingInt(Person::getAge));

        System.out.println(statistics);
    }

    /**
     * Custom Collector example
     */
    private static void customCollector() throws IOException {
        List<Person> persons = readPersons();

        Collector<Person, StringJoiner, String> personNameCollector =
                Collector.of(
                        () -> new StringJoiner(" | "),                      // supplier - creates the results container
                        (j, p) -> j.add(p.getLastName().toUpperCase()),     // accumulator - adds the value to the results container
                        (j1, j2) -> j1.merge(j2),                           // combiner - merges two partial results
                        StringJoiner::toString);                            // finisher - the final transformation

        String names = persons.stream().collect(personNameCollector);

        System.out.println(names);
    }

    public static void main(String[] args) throws IOException {

        // collectors are terminal operations that transform the elements of the stream into a different kind of result
        // eg: a list, a map, a set, etc; a Collector consists of four different operations:
        // a supplier
        // an accumulator
        // a combiner
        // a finisher

        // Fortunately Java already have many predefined collectors

        collectingIntoAList();
        groupingByAge();
        toMapExample();
        joiningPersonsByLastName();
        aggregatingTheElements();
        summarizingByAge();
        customCollector();
    }
}
