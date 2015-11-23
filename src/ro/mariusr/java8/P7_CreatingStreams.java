package ro.mariusr.java8;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mariusrop on 12.11.2015.
 */
public class P7_CreatingStreams {
    public static void main(String[] args) throws IOException {
        // there are multiple ways of creating streams / multiple kind of streams

        List<Person> persons = Person.readPersons();

        persons.stream();                   // by using stream() default method from Collection interface
        Stream.of("1", "2", "3");           // by using Stream.of
        IntStream.rangeClosed(0, 10);       // streams of primitive data types
        Arrays.stream(new int[]{1, 2});     // by using Arrays.stream
    }
}
